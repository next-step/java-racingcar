package racingcar.model;

import java.util.StringJoiner;

public class Result {
    public static void printResult(Cars cars){
        System.out.println(cars.getResult());
    }

    public static void printWinners(Cars cars) {
        StringJoiner joiner = new StringJoiner(", ", "", "가 최종 우승했습니다.");
        for (Car car : cars.getWinners()) {
            joiner.add(car.getName());
        }
        System.out.println(joiner.toString());
    }
}
