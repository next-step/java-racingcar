package com.seok.racing.domain;

import com.seok.racing.utils.StringUtils;

import java.util.Objects;

public class Position{

    protected static final Position ZERO = new Position();
    private static final String LOCATION_SYMBOL = "-";

    private int position;

    protected Position() {
        this(0);
    }

    protected Position(int position) {
        this.position = position;
    }

    protected void increment() {
        this.position++;
    }

    protected Position clone()  {
        return new Position(this.position);
    }

    protected boolean fastThan(Position position) {
        return this.position >= position.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return StringUtils.repeat(LOCATION_SYMBOL, position);
    }
}
