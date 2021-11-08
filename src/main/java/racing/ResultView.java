package racing;

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

            for (Car car : cars) {
                String step = createSteps(car.getStep());
                System.out.println(step);
            }
            System.out.println();
        }
    }

    private String createSteps(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
