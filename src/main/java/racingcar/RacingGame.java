package racingcar;

public class RacingGame {

    private static Car[] createCars(int num) {
        Car[] cars = new Car[num];
        for (int i = 0; i < num; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

}
