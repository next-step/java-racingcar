package racingcar;

import java.util.*;


public class RacingGame {
    private static final int RANDOM_FROM = 0;
    private static final int RANDOM_TO = 9;


    private List<Car> cars;

    public RacingGame(String[] carNames) {
        int carNumber = carNames.length;
        cars = new ArrayList<>(carNumber);

        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void gameStart(int inputTimes) {
        System.out.println("\n실행결과");

        for(int i = 0; i < inputTimes; i++) {
            ResultView.viewCars(move(new RandomUtil(RANDOM_FROM, RANDOM_TO)));
        }

        ResultView.viewWinner(GameResult.getWinner(cars));
    }

    public List<Car> move(RandomUtil randomUtil) {
        for(Car car: cars) {
            int randomNumber = randomUtil.randomInt();
            car.go(randomNumber);
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
