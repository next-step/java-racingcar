package core;

public class TestCarGenerator {
    public static Car generate(String carName, int position) {
        Car car = new Car(carName);
        for (int i = 0; i < position; i++) {
            car.move(Car.BASE_MOVE_VALUE);
        }
        return car;
    }
}
