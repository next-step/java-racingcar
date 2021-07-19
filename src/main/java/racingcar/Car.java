package racingcar;

import java.util.Objects;

class Car implements Comparable<Car> {
    private String name;
    private String position;

    private Car(String name, String position) {
        this.name = name;
        this.position = position;
    }

    static Car of(String name, String position) {
        return new Car(name, position);
    }

    Car changePosition(String position) {
        this.position += position;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return ((Objects.equals(name, car.name)) && (Objects.equals(position, car.position)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    String getName() {
        return name;
    }

    String getPosition() {
        return position;
    }

    int getPositionLength() {
        return position.length();
    }

    @Override
    public int compareTo(Car o) {
        return this.position.length() - o.position.length();
    }
}
