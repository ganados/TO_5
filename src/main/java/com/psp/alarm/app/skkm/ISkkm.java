package com.psp.alarm.app.skkm;

import com.psp.alarm.app.models.event.IEvent;
import com.psp.alarm.app.models.jrgstation.ijrgstation.IJRGstation;

public interface ISkkm {
    void save(IJRGstation ijrGstation);

    void delete(IJRGstation ijrGstation);

    boolean notifySkkm();

    boolean notifyAll(IEvent event);
}
