package study.race;

import java.util.ArrayList;
import java.util.Random;

public class CarRacing {

    public static void main(String[] args) {
        String[] names = InputView.scanNameOfCar().split(",");
        int racingCount = InputView.scanNumberOfCount();

        Car[] carNumbers = carArray(names.length);
        racing(racingCount, carNumbers);

    }

    private static void racing(int racingCount, Car[] carNumbers) {
        for(int i = 0; i< racingCount; i++){
            for(int j = 0; j< carNumbers.length; j++) {
                carNumbers[j].position += condition(getRandom());
            }
            ResultView.resultView(carNumbers);
            System.out.println("\n");
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


