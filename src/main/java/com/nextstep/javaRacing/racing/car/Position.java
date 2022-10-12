package com.nextstep.javaRacing.racing.car;

public class Position implements Comparable<Position>{

    private int position;

    public Position() {
        this(0);
    }

    public Position(final int position) {
        if(position < 0) {
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
        }
        this.position = position;
    }

    public int get() {
        return this.position;
    }

    public void move() {
        this.position = this.position + 1;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

    @Override
    public int compareTo(final Position o) {
        return Integer.compare(this.position, o.position);
    }
}
