package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class ResultView {

    public void printCars(Cars cars) {
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

    public void printHeader() {
        System.out.println("실행 결과");
    }

    public void print(String nameOfCar, int distance) {
        System.out.print(nameOfCar + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public void printWinners(Cars winnersNames) {
        System.out.println(String.join(",", winnersNames.getCarNames()) + "가 최종 우승했습니다.");
    }


}
