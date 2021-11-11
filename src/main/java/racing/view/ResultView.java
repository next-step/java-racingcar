package racing.view;

import racing.Car;
import racing.Racing;

import java.util.List;

/**
 * @author han
 */
public class ResultView {
    private String message = "실행 결과";

    public void print(Racing racing) {
        System.out.println(this.message);

        for (int i = 0; i < racing.getAttempts(); i++) {
            List<Car> cars = racing.getLogs().get(i);
            printStep(cars);
        }
    }

    private void printStep(List<Car> cars) {
        for (Car car : cars) {
            String step = createResult(car);
            System.out.println(step);
        }
        System.out.println();
    }

    private String createResult(Car car) {
        int count = car.getStep();
        String name = car.getName();

        StringBuilder sb = new StringBuilder();
        sb.append(name + " : ");

        for (int i = 0; i < count; i++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
