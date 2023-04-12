package racingcar;


import racingcar.service.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racingcar.service.Car.race;
import static racingcar.view.InputView.input;
import static racingcar.view.ResultView.view;
import static racingcar.view.ResultView.viewWinners;

public class RacingCarApplication {
    public static final Random random = new Random();

    public static void main(String[] args) {
        final var input = input();
        String[] carNames = (String[]) input.get(0);
        int labs = (int) input.get(1);

        List<Car> racingCars = new ArrayList<>();
        for (int car = 0; car < carNames.length; car++) {
            racingCars.add(new Car(carNames[car], race(labs)));
        }

        view(racingCars);
        viewWinners(getWinnerNames(racingCars));
    }

    public static String getWinnerNames(List<Car> racingCars) {
        int winnerScore = getWinnerScore(racingCars);

        StringBuilder winnerNames = new StringBuilder();
        for (Car car : racingCars) {
            winnerNames = hasWinnerScore(winnerScore, car) ? appendWinnerName(winnerNames, car) : winnerNames;
        }

        return winnerNames.toString();
    }

    private static boolean hasWinnerScore(int winnerScore, Car car) {
        return winnerScore == car.getState().get(car.getState().size() - 1);
    }

    private static StringBuilder appendWinnerName(StringBuilder winnerNames, Car car) {
        if(winnerNames.length() != 0){
            winnerNames.append(", ");
        }
        winnerNames.append(car.getName());

        return winnerNames;
    }

    private static int getWinnerScore(List<Car> racingCars) {
        int winnerScore = 0;
        for (Car car : racingCars) {
            winnerScore = checkWinnerScore(winnerScore, car);
        }
        return winnerScore;
    }

    private static int checkWinnerScore(int winnerScore, Car car) {
        int lastState = car.getState().get(car.getState().size() - 1);
        if (winnerScore < lastState) {
            winnerScore = lastState;
        }
        return winnerScore;
    }
}
