package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static String getWinnerNames(List<Car> winners) {
        List<String> winnersName = new ArrayList<>();
        for (Car winner : winners) {
            winnersName.add(winner.getName());
        }
        return   String.join(",", winnersName) + "가 우승자 입니다.";
    }

    public static void racingResultSave(RacingResult racingResult, List<Car> cars) {
        List<RaceTurnResult> raceTurnResults = racingResult.getRaceTurnResults();
        for (Car car : cars) {
            raceTurnResults.add(new RaceTurnResult(car.getName(), getCarDistance(car)));
        }
    }

    public static void consolePrintRacingResult(RacingResult racingResult) {
        List<RaceTurnResult> raceTurnResults = racingResult.getRaceTurnResults();
        for (RaceTurnResult raceTurnResult : raceTurnResults) {
            System.out.println(raceTurnResult.getCarName() + ":" + raceTurnResult.getDistance());

        }
    }

    private static String getCarDistance(Car car) {
        StringBuilder raceResult = new StringBuilder();
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        return String.valueOf(raceResult);
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
