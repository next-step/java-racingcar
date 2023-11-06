package racing;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static final String BEGINNING = "";

    static int carCount;
    static int raceRound;
    static List<RacingCar> cars = new ArrayList<>();

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        carCount = InputView.getCarCount();
        raceRound = InputView.getRaceRound();
        for (int i = 0; i < carCount; i++) {
            cars.add(new RacingCar(BEGINNING));
        }
        for (int i = 0; i < raceRound; i++) {
            raceAllCars(stringBuilder);
            stackResult(stringBuilder);
        }
        ResultView.showResult(stringBuilder);
    }

    private static void raceAllCars(StringBuilder stringBuilder) {
        for (RacingCar car : cars) {
            car.race();
            stackResult(stringBuilder.append(car));
        }
    }

    private static void stackResult(StringBuilder stringBuilder) {
        stringBuilder.append("\n");
    }
}
