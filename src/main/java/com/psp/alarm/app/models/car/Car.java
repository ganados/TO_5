package com.psp.alarm.app.models.car;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.psp.alarm.app.idgenerator.Ids;
import com.psp.alarm.app.models.car.state.State;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Car {
    private String id;
    private State state;

    public Car() {
        this.id = Ids.getId();
        this.state = State.FREE;
    }

    public void create(final boolean isFake) {
        setBusy();
        Random random = new Random();

        try {
            int travelTime = random.nextInt(4);
            TimeUnit.SECONDS.sleep(travelTime);

            if (!isFake) {
                TimeUnit.SECONDS.sleep(random.nextInt(20) + 5);
            }

            TimeUnit.SECONDS.sleep(travelTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Car " + getId() + " free");
        setFree();
    }

    public void setFree() {
        this.state = State.FREE;
    }

    public void setBusy() {
        this.state = State.BUSY;
    }
}
