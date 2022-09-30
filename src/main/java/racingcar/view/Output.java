package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {
    private static final String RESULT_VALUE = "-";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static StringBuilder sb = new StringBuilder();

    public static void resultString(List<Car> cars) {
        System.out.println(RESULT_MESSAGE);
        for (Car car : cars) {
            sb.append(RESULT_VALUE);
        }
        System.out.println(sb);
    }
}
