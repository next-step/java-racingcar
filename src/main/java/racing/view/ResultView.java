package racing.view;

import racing.model.TurnSnapshot;
import racing.model.CarSnapshot;
import racing.model.RacingResultDto;

public class ResultView {

    public static void printResult(RacingResultDto racingResultDto) {
        System.out.println("실행 결과");

        for (TurnSnapshot turnSnapshot : racingResultDto.getPlayHistory()) {
            printTurnResult(turnSnapshot);
        }

        String winners = String.join(", ", racingResultDto.getWinnerNames());
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private static void printTurnResult(TurnSnapshot turnSnapshot) {
        for (CarSnapshot car: turnSnapshot) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private static void printCarPosition(CarSnapshot car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

}
