package com.psp.alarm.app.models.event;

import com.psp.alarm.app.eventgenerator.Position;
import com.psp.alarm.app.skkm.alarmStates.FireAlarm;

public class FireEvent implements IEvent {

    @Override
    public int handle() {
        return new FireAlarm().handle();
    }

    @Override
    public Position getPosition() {
        return null;
    }
}
