package racingcar.view.output;

import racingcar.dto.output.RacingGameResponse;
import racingcar.dto.output.RacingGameRecord;
import racingcar.dto.output.RacingGameResult;

import java.util.List;

import static racingcar.common.Constant.SPLIT_LETTER;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(RacingGameResponse records) {
        System.out.println("실행 결과");
        for (RacingGameRecord record : records.getRacingGameRecords()) {
            printCars(record);
        }
        printWinners(records.getWinners());
    }

    private static void printCars(RacingGameRecord cars) {
        for (RacingGameResult car : cars.getValue()) {
            System.out.println(getCarPosition(car));
        }
        System.out.println();
    }

    private static String getCarPosition(RacingGameResult car) {
        StringBuilder carInformation = new StringBuilder();
        carInformation.append(car.getName().getValue());
        carInformation.append(" : ");
        for (int i = 0; i < car.getPosition().getValue(); i++) {
            carInformation.append("-");
        }
        return carInformation.toString();
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.println(String.join(SPLIT_LETTER, winnerNames) + "가 최종 우승했습니다.");
    }


}
