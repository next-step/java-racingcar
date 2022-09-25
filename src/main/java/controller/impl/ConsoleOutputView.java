package controller.impl;

import controller.OutputView;
import model.Car;
import model.GameResult;

import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(String.join(JOIN_DELIMITER,getWinnerNames(result)) + WINNER_MSG);
    }

    private List<String> getWinnerNames(GameResult result) {
        return result.getCars().stream().map(this::getCarName).collect(Collectors.toList());
    }

    @Override
    public void printResultMsg() {
        System.out.println(RUN_RESULT_MSG);
    }

    private String carToString(Car car) {
        return getCarName(car) + CAR_NAME_POSITION_DELIMITER + this.positionToString(this.getCarPosition(car));
    }

    private String getCarName(Car car) {
        return car.getCarName().getName();
    }
    private int getCarPosition(Car car) {
        return car.getCarPosition().getPosition();
    }

    private String positionToString(int currentPosition) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            builder.append(POSITION_STRING_UNIT);
        }
        return builder + "\n";
    }
}
