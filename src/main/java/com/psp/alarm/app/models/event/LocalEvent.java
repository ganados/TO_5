package com.psp.alarm.app.models.event;

import com.psp.alarm.app.eventgenerator.Position;
import com.psp.alarm.app.skkm.alarmStates.LocalAlarm;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LocalEvent implements IEvent {

    @Override
    public int handle() {
        return new LocalAlarm().handle();
    }

    @Override
    public Position getPosition() {
        return null;
    }
}
