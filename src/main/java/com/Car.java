package com;

public class Car {
    private int position;

    public Car(int firstPosition) {
        this.position = firstPosition;
    }

    public Car move(boolean b) {
        this.position += b == true ? 1 : 0;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < position; idx++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }
}
