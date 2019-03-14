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

    public static void racingResultSave(RacingResult racingResult) {
        List<String> resultList = racingResult.getResultList();
        for (Car car : racingResult.getCars()) {
            resultList.add(getCarDistance(car));
        }
    }

    public static void consolePrintRacingResult(RacingResult racingResult) {
        List<String> resultList= racingResult.getResultList();
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    private static String getCarDistance(Car car) {
        StringBuilder raceResult = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        return String.valueOf(raceResult);
    }

    public static void printBlankLine() {
        System.out.println();
    }

}
