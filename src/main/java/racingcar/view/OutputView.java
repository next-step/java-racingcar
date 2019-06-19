package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.WinningResult;

import java.util.stream.Collectors;

public class OutputView {

    private static final String VISUAL_EXPRESSION = "-";
    private static final String WINNING_NAMES_DELIMITER = ",";

    public static void start() {
        System.out.println("게임을 시작합니다.");
    }

    public static void ready(Cars cars) {
        System.out.println("실행 결과");
        getCurrentGameResult(cars);
    }

    public static void getCurrentGameResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
        }
        newLine();
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(VISUAL_EXPRESSION);
        }
        newLine();
    }

    public static void winningResult(WinningResult result) {
        String name = result.getNames().stream()
                .collect(Collectors.joining(WINNING_NAMES_DELIMITER));
        System.out.println(name + "가 최종 우승했습니다.");
    }

    public static void end() {
        System.out.print("게임을 종료합니다.");
    }

    private static void newLine() {
        System.out.println();
    }
}
