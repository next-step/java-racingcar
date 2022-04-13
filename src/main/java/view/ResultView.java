package view;

import racingcar.Cars;

import java.util.List;

public class ResultView {
    private static final String CAR_NAME_COLON = " : ";
    private static final String MOVE_EXPRESSION = "-";

    public static void print(List<Cars> raceResult) {
        System.out.println("실행 결과");
        raceResult.forEach(cars -> {
            cars.convertPositionToExpression(CAR_NAME_COLON, MOVE_EXPRESSION)
                    .forEach(System.out::println);
            System.out.println();
        });
        printWinners(raceResult.get(raceResult.size() - 1));
    }

    private static void printWinners(Cars cars) {
        System.out.println(cars.getWinners() + "가 최종 우승했습니다.");
    }

}
