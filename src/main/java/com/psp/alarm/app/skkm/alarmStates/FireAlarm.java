package com.psp.alarm.app.skkm.alarmStates;

import com.psp.alarm.app.skkm.alarmStates.alarm.Alarm;

public class FireAlarm implements Alarm {
    @Override
    public int handle() {
        return 5;
    }
}
