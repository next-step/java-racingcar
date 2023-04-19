package study.racingcar.view;

import study.racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String MOVE_MARK = "-";
    private static final String NAME_CLONE = " : ";
    private static final String END_GAME_MESSAGE = "게임이 종료되었습니다.";

    public ResultView () {}
    public void resultGame(List<Car> cars) {

        for(Car car : cars){
            result(car);
        }

        emptyLine();
    }

    public void emptyLine() {
        System.out.println();
    }

    public void startGame() {
        System.out.println("실행 결과");
    }

    private void printCarName(String name) {
        System.out.print(name + NAME_CLONE);
    }

    public void winner(List<String> winner) {
        System.out.println(String.join(", ", winner) + "가 최종 우승했습니다.");
    }

    public void endGame() {
        System.out.println(END_GAME_MESSAGE);
    }

    private void result(Car car) {
        printCarName(car.getName());

        for (int i = 0; i < car.currentPosition(); i++) {
            System.out.print(MOVE_MARK);
        }
        emptyLine();
    }
}
