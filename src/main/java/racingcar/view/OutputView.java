package racingcar.view;

import racingcar.Car;
import racingcar.RacingResult;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void PrintWinner(List<Car> winners) {
        List<String> winnersName = new ArrayList<>();
        for (Car winner : winners) {
            winnersName.add(winner.getName());
        }
        System.out.println(String.join(",", winnersName) + "가 우승자 입니다.");
    }

    public static void printResult(RacingResult racingResult) {
        for (Car car : racingResult.getCars()) {
            printCarDistance(car);
        }
    }

    private static void printCarDistance(Car car) {
        StringBuilder raceResult = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        System.out.println(raceResult.toString());
    }

    public static void printBlankLine() {
        System.out.println();
    }

}
