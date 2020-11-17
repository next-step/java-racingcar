package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class ResultView {

    public void printResult(List<Cars> records) {
        printHeader();
        for (Cars record : records) {
            printCars(record);
        }
    }

    private void printCars(Cars cars) {
        for (Car car : cars.getValue()) {
            System.out.println(getCarPosition(car));
        }
        System.out.println();
    }

    private String getCarPosition(Car car) {
        StringBuilder carInformation = new StringBuilder();
        carInformation.append(car.getName().getValue());
        carInformation.append(" : ");
        for (int i = 0; i < car.getPosition().getValue(); i++) {
            carInformation.append("-");
        }
        return carInformation.toString();
    }

    private void printHeader() {
        System.out.println("실행 결과");
    }

    public void printWinners(Cars lastRecord) {
        System.out.println(String.join(",", lastRecord.getCarNames()) + "가 최종 우승했습니다.");
    }


}
