package com.psp.alarm.app.idgenerator;

public class Ids {
    private static long id = 0;

    public static synchronized String getId()
    {
        return String.valueOf(id++);
    }
}
