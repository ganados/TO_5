package com.psp.alarm.app.eventgenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.psp.alarm.app.models.event.FireEvent;
import com.psp.alarm.app.models.event.IEvent;
import com.psp.alarm.app.models.event.LocalEvent;

import static com.psp.alarm.app.eventgenerator.constants.Constants.FIRE_PROBABILITY;
import static com.psp.alarm.app.eventgenerator.constants.Constants.MAXIMUM_RANGE_X;
import static com.psp.alarm.app.eventgenerator.constants.Constants.MAXIMUM_RANGE_Y;
import static com.psp.alarm.app.eventgenerator.constants.Constants.MINIMUM_RANGE_X;
import static com.psp.alarm.app.eventgenerator.constants.Constants.MINIMUM_RANGE_Y;

public class EventGenerator {

    private static final Random random = new Random();

    public static Position generatePosition() {
        double x = ThreadLocalRandom.current().nextDouble(MINIMUM_RANGE_X, MAXIMUM_RANGE_X);
        double y = ThreadLocalRandom.current().nextDouble(MAXIMUM_RANGE_Y, MINIMUM_RANGE_Y);
        return Position.of(x, y);
    }

    public static IEvent generateEvent() {
        if (random.nextInt(FIRE_PROBABILITY) < 3) {
            return new FireEvent();
        }
        return new LocalEvent();
    }
}
