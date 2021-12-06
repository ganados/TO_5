package com.psp.alarm.app.models.event;

import com.psp.alarm.app.eventgenerator.Position;

public interface IEvent {
    int handle();

    Position getPosition();
}
