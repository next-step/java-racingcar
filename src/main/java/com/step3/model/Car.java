package com.step3.model;

public class Car {
    private static final int MOVE_POSSIBLE_BOUND = 4;

    private int id;
    private int position;

    public Car(int id, int firstPosition) {
        this.id = id;
        this.position = firstPosition;
    }

    public Car move(int randomValue) {
        this.position += (isMovePossible(randomValue) == true) ? 1 : 0;
        return this;
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < position; idx++) {
            sb.append("-");
        }
        return sb.toString();
    }


    private static boolean isMovePossible(int randomValue) {
        return randomValue >= MOVE_POSSIBLE_BOUND ? true : false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }
}
