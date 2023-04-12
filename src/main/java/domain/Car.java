package domain;

public class Car {
    int position;

    Car(int position) {
        this.position = position;
    }

    Car(Car car) {
        this.position = car.position;
    }

    public void move(int nextInt) {
        position += nextInt;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car))
            return false;
        Car car = (Car) obj;
        return this.position == car.position;
    }

    @Override
    public String toString() {
        return String.format("{location : %d}", position);
    }
}
