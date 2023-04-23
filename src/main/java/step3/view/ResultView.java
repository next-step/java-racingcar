package step3.view;

import step3.model.Car;
import step3.model.Cars;

import java.util.List;

public class ResultView {

    public static final String DASH = "-";

    public void drawing(List<Car> cars) {
        for (Car car : cars) {
            drawDash(car);
        }
        System.out.println();
    }

    public void winner(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    public void startUI() {
        System.out.println("실행결과");
    }

    private void drawDash(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i <= car.getDistance(); i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }
}
