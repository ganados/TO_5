package com.psp.alarm.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.psp.alarm.app.eventgenerator.Position;
import com.psp.alarm.app.models.event.Event;
import com.psp.alarm.app.models.jrgstation.JRGStation;
import com.psp.alarm.app.models.jrgstation.ijrgstation.IJRGstation;
import com.psp.alarm.app.skkm.ISkkm;
import com.psp.alarm.app.skkm.Skkm;

import lombok.SneakyThrows;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        List<IJRGstation> stations = List.of(
                new JRGStation("1", Position.of(50.060026506499206, 19.942913687967124)),
                new JRGStation("2", Position.of(50.03381017495707, 19.937377226612714)),
                new JRGStation("3", Position.of(50.084966689684386, 19.863450590629313)),
                new JRGStation("4", Position.of(50.0378530292807, 20.005756855014358)),
                new JRGStation("5", Position.of(50.09234339349529, 19.922380485906324)),
                new JRGStation("6", Position.of(50.0164523302028, 20.017011360064917)),
                new JRGStation("7", Position.of(50.09411730070909, 19.977544822836308)),
                new JRGStation("8", Position.of(50.07841255948872, 20.036627991006)),
                new JRGStation("9", Position.of(49.99067039026655, 19.736245522102028)),
                new JRGStation("10", Position.of(50.08267540079839, 19.8))
        );

        ISkkm skkm = new Skkm(new ArrayList<>());
        stations.forEach(skkm::save);

        while (true) {
            if(skkm.notifySkkm()) {
                TimeUnit.SECONDS.sleep(1);
            }
            if (!skkm.notifyAll(new Event())) {
                TimeUnit.SECONDS.sleep(1);
            }
        }

    }
}
