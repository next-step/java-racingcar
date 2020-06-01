package game;

import java.util.List;

public class ResultRacingPlayer extends ResultView {

    private static final String PLAYER_NAME_SEPARATOR = " : ";

    private static final String WINNER_NAME_SEPARATOR = ", ";

    private static final String WINNING_MESSAGE = "가 최종 우승했습니다.";

    public ResultRacingPlayer() {
        super();
    }

    /**
     * 자동차 이름 부여 경기 실행 결과 출력
     *
     * @param cars
     * @param numberOfAttempts
     */
    public void racingResultWithPlayer(List<Car> cars, int numberOfAttempts) {

        for (int i = 0; i < numberOfAttempts; i++) {
            printCars(cars, i);
            printLine();
        }
    }

    public void printCars(List<Car> cars, int currentPosition) {

        for (Car car : cars) {
            printContents(car.getName() + PLAYER_NAME_SEPARATOR);
            printPosition(car.getPosition().get(currentPosition));
        }
    }

    public void printPosition(Position position) {

        printView(position.getPosition(), ResultView.LOG_DISPLAY);
    }

    public void printContents(String contents) {

        System.out.print(contents);
    }

    public void printWinner(List<Car> cars) {

        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            printComma(stringBuilder);
            stringBuilder.append(car.getName());
        }

        printContents(stringBuilder.toString() + WINNING_MESSAGE);

        printLine();
    }

    public void printComma(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append(WINNER_NAME_SEPARATOR);
        }
    }

    public static ResultRacingPlayer create() {
        return new ResultRacingPlayer();
    }
}
