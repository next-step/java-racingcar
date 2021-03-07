package step3;

import java.util.*;

public class CarRacing {

    public static final int RANDOM_RANGE = 10;
    public List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {

        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }

    public void start() {
        InputView inputView = new InputView();
        createCars(cars, inputView.getAmountOfCar());
        Random random = new Random();
        System.out.println("\n실행 결과");
        moveCars(inputView.getCountOfCar(), random);
    }

    private static void createCars(List<Car> cars, int amountOfCar) {
        for (int i = 0; i< amountOfCar; i++) {
            cars.add(new Car(i));
        }
    }

    private void moveCars(int countOfCar, Random random) {
        for (int i = 0; i < countOfCar; i++) {
            updateMoveOfCar(cars, random);
            System.out.println();
        }
    }

    private static void updateMoveOfCar(List<Car> cars, Random random) {
        cars.forEach(car -> {
            car.updateMove(random.nextInt(RANDOM_RANGE));
            car.print();
        });
    }
}