package com.psp.alarm.app.eventgenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class Position {
    final double x;
    final double y;
}
