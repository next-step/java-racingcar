package study.race;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRacing {

    public static void main(String[] args) {
        String value = InputView.scanNumberOfCar();
        int racingCount = InputView.scanNumberOfCount();
        int carCount = Integer.parseInt(value);
        List<Car> carNumbers = carArray(carCount);

        int number = -1;
        race(racingCount, carNumbers, number);
    }

    public static List<Car> race(int racingCount, List<Car> carNumbers, int number) {
        for (int i = 0; i < racingCount; i++) {
            for (int j = 0; j < carNumbers.size(); j++) {
                carNumbers.get(j).position += Car.condition(getRandomNumber(number));
            }
            printResult(carNumbers);
        }
        return carNumbers;
    }

    public static void printResult(List<Car> carNumbers) {
        ResultView.resultView(carNumbers);
        System.out.println("\n");
    }

    public static int getRandomNumber(int number) {
        if (number != -1) {
            return number;
        }
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }

    public static List<Car> carArray(int carCount) {
        return Stream.generate(Car::new)
                .limit(carCount)
                .collect(Collectors.toList());
    }
}


