package step3.view;

import step3.model.Car;

import java.util.List;

public class ResultView {

    public static final String DASH = "-";

    public void drawing(List<Car> cars) {
        for (Car car : cars) {
            drawDash(car.getDistance());
        }
        System.out.println();
    }

    public void startUI() {
        System.out.println("실행결과");
    }

    private void drawDash(int distance) {
        for (int i = 0; i <= distance; i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }
}
