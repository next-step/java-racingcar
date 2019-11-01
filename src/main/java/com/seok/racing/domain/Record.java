package com.seok.racing.domain;

import java.text.MessageFormat;

public class Record {

    private final static String TO_STRING_PATTERN = "{0} : {1}";

    private final Racer racer;
    private final Position position;

    protected Record(Racer racer, Position position) {
        this.racer = racer;
        this.position = position;
    }

    @Override
    public String toString() {
        return MessageFormat.format(TO_STRING_PATTERN, racer.toString(), position.toString());
    }
}
