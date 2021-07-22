package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MAX_VALUE = 10;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] carNames = inputView.insertCarName();
        int carNumber = carNames.length;
        int tryNumber = inputView.getNumberOfTry();

        List<Car> cars = Car.createCars(carNames, carNumber);

        for(int i = 0; i < tryNumber; i++) {
            printAll(cars);
            System.out.println();
        }

        Collections.reverse(cars);

        int first = cars.stream().map(Car::getMoveSpace)
                                 .max(Integer::compareTo)
                                 .get();

        List<Car> winners = cars.stream()
                                .filter(car -> car.getMoveSpace() == first)
                                .collect(Collectors.toList());

        resultView.getWinner(winners);
    }

    public static void printAll(List<Car> cars) {
        ResultView resultView = new ResultView();
        for(Car car: cars) {
            Random random = new Random();

            int randomNumber = random.nextInt(MAX_VALUE);
            int moveNumber = car.move(randomNumber);

            resultView.print(car.getName(), moveNumber);
        }
    }
}
