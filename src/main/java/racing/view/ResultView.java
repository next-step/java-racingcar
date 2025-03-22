package racing.view;

import racing.model.CarsAtTurn;
import racing.model.FixedCar;
import racing.model.RacingResultDto;

public class ResultView {

    public static void printResult(RacingResultDto racingResultDto) {
        System.out.println("실행 결과");

        for (CarsAtTurn carsAtTurn : racingResultDto.getPlayHistory()) {
            printTurnResult(carsAtTurn);
        }

        String winners = String.join(", ", racingResultDto.getWinnerNames());
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private static void printTurnResult(CarsAtTurn carsAtTurn) {
        for (FixedCar car: carsAtTurn) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private static void printCarPosition(FixedCar car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

}
