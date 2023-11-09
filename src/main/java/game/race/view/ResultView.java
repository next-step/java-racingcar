package game.race.view;

import java.util.List;

import game.race.Car;

public class ResultView {

    private static final String SHOW_RESULT = "실행 결과";
    private static final String END_MARK = "";
    private static final String MARK = "-";

    public void showPrompt() {
        System.out.println(SHOW_RESULT);
    }

    public void showCars(List<Car> cars) {
        for (Car car : cars) {
            printMark(car.getMoveCount());
        }

        System.out.println(END_MARK);
    }

    private void printMark(int moveCount) {
        String tireMark = (moveCount == 0) ? MARK : MARK.repeat(moveCount);
        System.out.println(tireMark);
    }
}
