package com.psp.alarm.app.models.jrgstation.ijrgstation;

import com.psp.alarm.app.eventgenerator.Position;
import com.psp.alarm.app.models.event.IEvent;

public interface IJRGstation {
    void update(final IEvent event, final int cars);

    String getId();

    Position getPosition();

    int getAvailableCars();
}
