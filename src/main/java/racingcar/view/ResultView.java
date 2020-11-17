package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class ResultView {

    public static void printResult(List<Cars> records) {
        System.out.println("실행 결과");
        for (Cars record : records) {
            printCars(record);
        }
    }

    private static void printCars(Cars cars) {
        for (Car car : cars.getValue()) {
            System.out.println(getCarPosition(car));
        }
        System.out.println();
    }

    private static String getCarPosition(Car car) {
        StringBuilder carInformation = new StringBuilder();
        carInformation.append(car.getName().getValue());
        carInformation.append(" : ");
        for (int i = 0; i < car.getPosition().getValue(); i++) {
            carInformation.append("-");
        }
        return carInformation.toString();
    }

    public static void printWinners(Cars lastRecord) {
        System.out.println(String.join(",", lastRecord.getCarNames()) + "가 최종 우승했습니다.");
    }


}
