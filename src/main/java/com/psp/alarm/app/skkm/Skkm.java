package com.psp.alarm.app.skkm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.psp.alarm.app.eventgenerator.Position;
import com.psp.alarm.app.models.event.IEvent;
import com.psp.alarm.app.models.jrgstation.ijrgstation.IJRGstation;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import static java.util.Map.Entry.comparingByValue;

@Log
@AllArgsConstructor
public class Skkm implements ISkkm {
    private List<IJRGstation> observers;

    @Override
    public void save(IJRGstation ijrGstation) {
        observers.add(ijrGstation);
    }

    @Override
    public void delete(IJRGstation ijrGstation) {
        observers.removeIf(station -> station.getId().equals(ijrGstation.getId()));
    }

    @Override
    public boolean notifySkkm() {
        return getFreeCars() == 0;
    }

    private int getFreeCars() {
        int cars = 0;
        for (IJRGstation ijrGstation : observers) {
            cars += ijrGstation.getAvailableCars();
        }
        return cars;
    }

    @Override
    public boolean notifyAll(IEvent event) {
        HashMap<IJRGstation, Double> distances = new HashMap<>();

        for (final IJRGstation observer : observers) {
            distances.put(observer, getDistance(observer, event));
        }
        LinkedHashMap<IJRGstation, Double> sortedDistances = sortMap(distances);

        int carsNeeded = event.handle();

        log.info("Event at position: " + event.getPosition() + "\n needed cars: " + carsNeeded);

        for (IJRGstation ijrGstation : sortedDistances.keySet()) {
            if (ijrGstation.getAvailableCars() >= carsNeeded) {
                ijrGstation.update(event, carsNeeded);
                carsNeeded = 0;
                break;
            } else {
                carsNeeded -= ijrGstation.getAvailableCars();
                ijrGstation.update(event, ijrGstation.getAvailableCars());
            }
        }
        return carsNeeded == 0;
    }

    private Double getDistance(IJRGstation observer, IEvent event) {
        Position eventPosition = event.getPosition();
        Position observerPosition = observer.getPosition();

        return Math.sqrt(Math.pow(observerPosition.getX() - eventPosition.getX(), 2) + Math.pow(observerPosition.getY() - eventPosition.getY(), 2));
    }

    private LinkedHashMap<IJRGstation, Double> sortMap(HashMap<IJRGstation, Double> distances) {
        return distances.entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }
}