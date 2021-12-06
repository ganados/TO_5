package com.psp.alarm.app.models.car.state;

import lombok.Getter;

@Getter
public enum State {
    FREE ("FREE"),
    BUSY ("BUSY");

    private final String state;
    State(final String s) {
        this.state = s;
    }
}
