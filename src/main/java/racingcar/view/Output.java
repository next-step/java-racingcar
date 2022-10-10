package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String RESULT_VALUE = "-";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_ANNOUNCE = "가 최종 우승했습니다.";
    private static StringBuilder sb = new StringBuilder();

    public static void resultString(List<Car> cars) {
        System.out.println(RESULT_MESSAGE);
        for (Car car : cars) {
            System.out.print(car.getName() + ": ");
            for (int i = 0; i <= car.getPosition(); i++) {
                System.out.print(RESULT_VALUE);
            }
            System.out.println();
        }
    }

    public static void resultRacingString(List<Car> cars) {
        sb.append(cars.get(0).getName());

        for (int i = 1; i < cars.size(); i++) {
            sb.append(", ").append(cars.get(i).getName());
        }
        sb.append(RESULT_ANNOUNCE);
        System.out.println(sb);
    }
}
