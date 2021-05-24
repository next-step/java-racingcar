package car.domain;

public class Cut {
    private static final int NAME_MAX_SIZE = 5;

    public Car getCar(String carName) {
        int length = carName.length();
        if (length > NAME_MAX_SIZE) {
            length = NAME_MAX_SIZE;
        }
        Car car = new Car(carName.substring(0, length), 0);
        return car;
    }
}
