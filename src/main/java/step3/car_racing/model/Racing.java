package step3.car_racing.model;

public class Racing {

    private static final Integer RANDOM_RANGE = 9;
    private static final Integer STANDARD_VALUE = 4;

    public Integer racing(Car car) {
        if ((int) (Math.random() * RANDOM_RANGE) > STANDARD_VALUE) {
            return car.moveForward();
        }
        return car.getDistance();
    }

}
