package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void printResult(List<Car> racingCars) {
        for(Car car : racingCars) {
            System.out.println(car.getCurrentPosition());
        }
        System.out.println();
    }

    public static void printResultStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarCountQuestion() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printTryCountQuestion() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }
}
