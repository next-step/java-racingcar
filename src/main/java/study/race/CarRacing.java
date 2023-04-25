package study.race;

import java.util.ArrayList;
import java.util.Random;

public class CarRacing {

    public static void main(String[] args) {
        String[] names = InputView.scanNameOfCar().split(",");
        stringCheck(names);
        int racingCount = InputView.scanNumberOfCount();
        Car[] carNumbers = carArray(names.length);
        carNumbers = namingCar(names, carNumbers);
        racing(racingCount, carNumbers);
    }

    private static void racing(int racingCount, Car[] carNumbers) {
        for (int i = 0; i < racingCount; i++) {
            movingCar(carNumbers);
            ResultView.resultView(carNumbers);
            System.out.println("\n");
        }
    }

    private static void movingCar(Car[] carNumbers) {
        for (int j = 0; j < carNumbers.length; j++) {
            carNumbers[j].position += condition(getRandom());
        }
    }

    private static Car[] namingCar(String[] names, Car[] carNumbers) {
        for (int i = 0; i < names.length; i++) {
            carNumbers[i].name += names[i];
        }
        return carNumbers;
    }

    public static void stringCheck(String[] names) {
        for (int i = 0; i < names.length; i++) {
            conditionStringCheck(names, i);
        }
    }

    private static void conditionStringCheck(String[] names, int i) {
        if (names[i].length() > 5) {
            throw new StringIndexOutOfBoundsException("String index out of range: 5");
        }
    }

    private static int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static Car[] carArray(int carCount) {
        Car[] car = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            car[i] = new Car();
        }
        return car;
    }

    public static int condition(int random) {
        if (random >= 4) {
            return 1;
        }
        return 0;
    }

}


