package racingcar;

import racingcar.utils.CarsGenerator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;

public class RacingSimulator {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        RandomNumberGenerator randomGenerator = new RandomNumberGenerator();
        CarsGenerator carsGenerator = new CarsGenerator();

        System.out.println("자동차 대수는 몇 대 인가요?");
        int countOfCar = inputView.insertCount();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int countOfRacing = inputView.insertCount();

        Car[] cars = carsGenerator.generateCars(countOfCar);

        for (int i = 0; i < countOfRacing; i++) {
            for (Car car : cars) {
                Integer integer = randomGenerator.generatorNumber(10);
                car.move(integer);
            }
        }

        for (Car car : cars) {
            System.out.println(car.getDistance());
        }

    }

    private Car[] initCars(Integer carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
        return cars;
    }
}
