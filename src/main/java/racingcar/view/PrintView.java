package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class PrintView {

    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void printCarStatus(List<Car> carList) {
        carList.forEach(car -> System.out.println(carToStatus(car)));
    }

    public String carToStatus(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName())
                .append(" : ");

        for (int i = 0; i < car.getPosition(); i++) {
            builder.append("-");
        }

        return builder.toString();
    }
}
