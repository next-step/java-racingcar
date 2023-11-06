package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public void viewGame(List<Car> cars) {
        for (Car car : cars){
            String printValue = "-".repeat(car.getPosition());
            System.out.println(printValue);

        }
        System.out.println();
    }

    public void view() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
