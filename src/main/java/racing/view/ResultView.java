package racing.view;

import racing.model.CarsAtTurn;
import racing.model.RacingResultDto;

public class ResultView {

    public static void printResult(RacingResultDto racingResultDto) {
        System.out.println("실행 결과");
        for (CarsAtTurn carsAtTurn : racingResultDto.getPlayHistory().getPositions()) {
            printTurnResult(carsAtTurn);
        }

        String winners = String.join(", ", racingResultDto.getWinnerNames());
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private static void printTurnResult(CarsAtTurn carsAtTurn) {
        for (int i=0; i<carsAtTurn.getCarSize(); i++) {
            printCarPosition(carsAtTurn.getCarName(i), carsAtTurn.getCarPosition(i));
        }
        System.out.println();
    }

    private static void printCarPosition(String carName, int carPosition) {
        System.out.println(carName + " : " + "-".repeat(carPosition));
    }

}
