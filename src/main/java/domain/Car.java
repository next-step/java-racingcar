package domain;

public class Car {
    int location;

    Car() {
        location = 1;
    }

    Car(int location) {
        this.location = location;
    }

    Car(Car car) {
        this.location = car.location;
    }

    public void move(int nextInt) {
        location += nextInt;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car))
            return false;
        Car car = (Car) obj;
        return this.location == car.location;
    }

    @Override
    public String toString() {
        return String.format("{location : %d}", location);
    }
}
