package com.racing.game.entity;

import java.util.Objects;

public class Car {
    private final String name;

    private int progress = 0;

    private Car(String name){
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name.length()>5){
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘어서면 안됩니다.");
        }
    }

    public static Car from(String name){
        return new Car(name);
    }

    public void incrementProgress(){
        progress++;
    }

    @Override
    public String toString() {
        return name.concat(" : ").concat("-".repeat(progress));
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
        return progress == car.progress && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, progress);
    }
}
