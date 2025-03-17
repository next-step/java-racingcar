package view;

import racing.CarPositions;
import racing.RacingResultDto;

import java.util.List;

public class ResultView {

    public static void printResult(RacingResultDto racingResultDto) {
        System.out.println("실행 결과");
        for (CarPositions carPositions : racingResultDto.getPlayHistory()) {
            printTurnResult(racingResultDto.getCarNames(), carPositions);
        }

        String winners = String.join(", ", racingResultDto.getWinnerNames());
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private static void printTurnResult(List<String> carNames, CarPositions carPositions) {
        for (int i=0; i<carNames.size(); i++) {
            printCarPosition(carNames.get(i), carPositions.getCarPosition(i));
        }
        System.out.println();
    }

    private static void printCarPosition(String carName, int carPosition) {
        System.out.println(carName + " : " + "-".repeat(carPosition));
    }

}
