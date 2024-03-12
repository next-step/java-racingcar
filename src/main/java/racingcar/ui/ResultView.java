package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

    private static final String CAR_POSITION_STRING = "-";

    private ResultView() {

    }

    public static void printAnswerHowManyCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printAnswerHowManyTrys() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }

    public static void printExecuteResultString() {
        System.out.println("실행 결과");
    }

    public static void print(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.get()) {
            String carPosition = CAR_POSITION_STRING.repeat(car.getDistance());
            stringBuilder.append(carPosition).append("\n");
        }

        System.out.println(stringBuilder);
    }

}
