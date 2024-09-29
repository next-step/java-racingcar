package racing.domain;

public class Car {

    private int position;

    public int getCurrentPosition() {
        return position;
    }

    public static Car createCar() {
        return new Car(0);
    }

    private Car(int position) {
        this.position = position;
    }
}
