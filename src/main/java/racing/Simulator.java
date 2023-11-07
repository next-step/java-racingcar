package racing;

import racing.model.RacingCar;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Simulator {
    private static final int BEGINNING = 0;

    static String[] carName;
    static int carCount;
    static int raceRound;
    static List<RacingCar> cars = new ArrayList<>();

    public static void main(String[] args) {
        carName = InputView.getCarName();
        carCount = carName.length;
        raceRound = InputView.getRaceRound();
        for (int i = 0; i < carCount; i++) {
            cars.add(new RacingCar(BEGINNING, carName[i]));
        }
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < raceRound; i++) {
            raceAllCars();
            System.out.println();
        }
        ResultView.showWinners(getWinners(cars));
    }

    public static List<RacingCar> getWinners(List<RacingCar> cars) {
        int topSpeed = getTopSpeed(cars);
        return cars.stream()
                .filter(car -> car.getProgress() == topSpeed)
                .collect(Collectors.toList());
    }

    public static int getTopSpeed(List<RacingCar> cars) {
        int max = 0;
        for (RacingCar car : cars) {
            max = Math.max(max, car.getProgress());
        }
        return max;
    }

    private static void raceAllCars() {
        for (RacingCar car : cars) {
            car.race(car.getRandomInt());
            ResultView.showRaceProgress(car);
        }
    }

}
