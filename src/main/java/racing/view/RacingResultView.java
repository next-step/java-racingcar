package racing;

import java.util.List;

public class RacingResultView {

    private static final String EXECUTE_RESULT_MESSAGE = "%n실행 결과%n" ;
    private static final String WINNER_RESULT_MESSAGE = "%s가 최종 우승했습니다.%n";
    private static final String MOVE_CAR_EXPRESSION = "- ";
    private static final String COMMA_CHARACTER = ",";
    private static final String WRONG_INPUT_VALUE = "잘못된 입력 값입니다.";
    private static final String EMPTY_SPACE_CHARACTER = " ";

    public RacingResultView() {
        System.out.printf(EXECUTE_RESULT_MESSAGE);
    }

    public void print(List<Car> racingCars) {
        for (Car racingCar : racingCars) {
            execute(racingCar);
        }
        System.out.println();
    }

    private void execute(Car racingCar) {
        int position = racingCar.position;
        System.out.print(racingCar.carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_CAR_EXPRESSION);
        }
        System.out.println();
    }

    public void printWinner(List<Car> racingCars) {
        StringBuilder winners = new StringBuilder();
        int winnerPosition = -1;
        for (Car racingCar : racingCars) {
            winners = checkWinners(winners, winnerPosition, racingCar);
            winnerPosition = racingCar.comparePositionWith(winnerPosition);
        }
        System.out.printf(WINNER_RESULT_MESSAGE, winners.toString());
    }

    private StringBuilder checkWinners(StringBuilder winners, int winnerPosition, Car currentRacingCar) {
        if (winners.length() == 0) {
            return winners.append(currentRacingCar.carName);
        }
        if (currentRacingCar.isBiggerThanWinnerPosition(winnerPosition)) {
            return new StringBuilder(currentRacingCar.carName);
        }
        if (currentRacingCar.isEqualWinnerPosition(winnerPosition)) {
            return winners.append(COMMA_CHARACTER).append(EMPTY_SPACE_CHARACTER).append(currentRacingCar.carName);

        }

        return winners;
    }
}
