package racingcar.model;

public class Garage {

    public static Car[] cars;

    public static void createCars(int number) {
        cars = new Car[number];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
    }
}
