package com.racing.game.entity;

import com.racing.game.utils.CarRandomMove;
import com.racing.game.vo.Progress;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String name;

    private Progress progress;

    private Car(String name) {
        validateName(name);
        this.name = name;
        this.progress = Progress.from(0);
    }

    private Car(String name, int progress) {
        validateName(name);
        this.name = name;
        this.progress = Progress.from(progress);
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘어서면 안됩니다.");
        }
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public static Car of(String name, int progress) {
        return new Car(name, progress);
    }

    public void incrementProgress() {
        if (CarRandomMove.isGoForward()) {
            progress = progress.goForward();
        }
    }

    public String name() {
        return name;
    }

    public int progress() {
        return this.progress.value();
    }

    public boolean isAheadFrom(int progress) {
        return this.progress.isGreaterThan(progress);
    }

    public boolean isSame(int progress) {
        return this.progress.isSame(progress);
    }

    @Override
    public String toString() {
        return name.concat(" : ").concat(progress.status());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(progress, car.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, progress);
    }

    @Override
    public int compareTo(Car o) {
        return this.progress.compareTo(o.progress);
    }
}
