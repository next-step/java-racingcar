package game.race.model;

import java.util.List;

import game.race.Car;

public class ResultView {

    private static final String SHOW_RESULT = "실행 결과";
    private static final String END_MARK = "";
    private static final String MARK = "-";

    public void showPrompt() {
        System.out.println(SHOW_RESULT);
    }

    public void markEnd() {
        System.out.println(END_MARK);
    }

    public void showCars(List<Car> cars) {
        for (Car car : cars) {
            printMark(car.getMoveCount());
        }
    }

    private void printMark(int moveCount) {
        if (moveCount == 0) {
            System.out.println(MARK);
            return;
        }

        String tireMark = "";
        for (int move = 0; move < moveCount; move++) {
            tireMark = tireMark.concat(MARK);
        }

        System.out.println(tireMark);
    }
}
