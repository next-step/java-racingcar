package carrace.view;

import carrace.Car;

import java.util.List;

public class ResultView {
    public void result(List<Car> cars, int round) {
        System.out.println("실행 결과");

        for (int i = 0; i < round; i++) {
            int finalI = i;
            cars.stream().forEach(car -> drawTrace(car, finalI));
            System.out.println();
        }
    }

    private void drawTrace(Car car, int round) {
        int position = car.getPositionAtRound(round);
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
