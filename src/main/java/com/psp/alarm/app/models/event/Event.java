package com.psp.alarm.app.models.event;

import com.psp.alarm.app.eventgenerator.EventGenerator;
import com.psp.alarm.app.eventgenerator.Position;
import com.psp.alarm.app.idgenerator.Ids;

import lombok.Getter;

@Getter
public class Event implements IEvent{
    private final String id;
    private final IEvent iEvent;
    private final Position position;

    public Event() {
        this.id = Ids.getId();
        this.position = EventGenerator.generatePosition();
        this.iEvent = EventGenerator.generateEvent();
    }

    @Override
    public int handle() {
        return this.iEvent.handle();
    }

    @Override
    public Position getPosition() {
        return this.position;
    }
}
