package racing;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static final int BEGINNING = 0;

    static int carCount;
    static int raceRound;
    static List<RacingCar> cars = new ArrayList<>();

    public static void main(String[] args) {
        carCount = InputView.getCarCount();
        raceRound = InputView.getRaceRound();
        for (int i = 0; i < carCount; i++) {
            cars.add(new RacingCar(BEGINNING));
        }
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < raceRound; i++) {
            raceAllCars();
            System.out.println();
        }
    }

    private static void raceAllCars() {
        for (RacingCar car : cars) {
            car.race(car.getRandomInt());
            ResultView.showResult(car.getProgress());
        }
    }

}
