package study.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    public static void main(String[] args) {
        String[] names = InputView.scanNameOfCar().split(",");
        stringCheck(names);
        int racingCount = InputView.scanNumberOfCount();

        Car[] carNumbers = carArray(names.length);
        carNumbers = namingCar(names, carNumbers);
        racing(racingCount, carNumbers);

        int max = getMax(carNumbers);
        List<String> maxName = getMaxName(carNumbers, max);
        ResultView.resultViewWinner(max, maxName);
    }

    private static List<String> getMaxName(Car[] carNumbers, int max) {
        List<String> namemax = new ArrayList<>(carNumbers.length);
        for (int i = 0; i < carNumbers.length; i++) {
            checkMaxName(carNumbers, max, namemax, i);
        }
        return namemax;
    }

    private static void checkMaxName(Car[] carNumbers, int max, List<String> namemax, int i) {
        if (carNumbers[i].position == max) {
            namemax.add(carNumbers[i].name);
        }
    }

    private static int getMax(Car[] carNumbers) {
        int max = 0;
        for (int i = 0; i < carNumbers.length; i++) {
            int position = carNumbers[i].position;
            max = checkMax(carNumbers, max, i);
        }
        return max;
    }

    private static int checkMax(Car[] carNumbers, int max, int i) {
        if (carNumbers[i].position > max) {
            max = carNumbers[i].position;
        }
        return max;
    }

    private static void racing(int racingCount, Car[] carNumbers) {
        print(carNumbers);
        for (int i = 0; i < racingCount; i++) {
            print(carNumbers);
            movingCar(carNumbers);
        }
    }

    private static void print(Car[] carNumbers) {
        ResultView.resultViewRace(carNumbers);
        System.out.println("\n");
    }

    private static void movingCar(Car[] carNumbers) {
        for (int j = 0; j < carNumbers.length; j++) {
            carNumbers[j].position += condition(getRandom());
        }
    }

    private static Car[] namingCar(String[] names, Car[] carNumbers) {
        for (int i = 0; i < names.length; i++) {
            carNumbers[i].name = names[i];
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


