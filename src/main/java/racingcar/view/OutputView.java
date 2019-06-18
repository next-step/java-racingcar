package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Position;
import racingcar.model.WinningResult;

import java.util.stream.Collectors;


public class OutputView {

    private static final String VISUAL_EXPRESSION = "-";

    public static void start() {
        System.out.println("게임을 시작합니다.");
    }

    public static void ready(Cars result) {
        System.out.println("실행 결과");
        playResult(result);
    }

    public static void playResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            newLine();
        }
        newLine();
    }

    private static void printPosition(Position position) {
        for (int i = 0; i < position.parseInt(); i++) {
            System.out.print(VISUAL_EXPRESSION);
        }
    }

    public static void winningResult(WinningResult result) {
        System.out.println("우승위치: " + result.getPosition());

        String name = result.getNames().stream()
                .collect(Collectors.joining(","));

        System.out.println(name + "가 최종 우승했습니다.");
    }

    public static void end() {
        System.out.print("게임을 종료합니다.");
    }

    private static void newLine() {
        System.out.println();
    }
}
