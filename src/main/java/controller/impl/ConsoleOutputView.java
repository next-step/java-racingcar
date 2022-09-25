package controller.impl;

import controller.OutputView;
import model.Car;
import model.GameResult;

public class ConsoleOutputView implements OutputView {

    private static final String POSITION_STRING_UNIT = "-";
    private static final String JOIN_DELIMITER = ",";
    private static final String CAR_NAME_POSITION_DELIMITER = ":";

    @Override
    public void printResult(GameResult result) {
        System.out.println();
        result.getCars().stream().map(this::carToString).forEach(System.out::print);

    }

    @Override
    public void printWinner(GameResult result) {
        String winnerNames = result.getCars().stream().map(this::getCarName).reduce((x, y) -> String.join(JOIN_DELIMITER, x, y)).orElseThrow(IllegalStateException::new);
        System.out.println(winnerNames + WINNER_MSG);
    }

    @Override
    public void printResultMsg() {
        System.out.println(RUN_RESULT_MSG);
    }

    private String carToString(Car car) {
        return getCarName(car) + CAR_NAME_POSITION_DELIMITER + this.positionToString(car.getCurrentPosition());
    }

    private String getCarName(Car car) {
        return car.getCarName().getName();
    }

    private String positionToString(int currentPosition) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            builder.append(POSITION_STRING_UNIT);
        }
        return builder + "\n";
    }
}
