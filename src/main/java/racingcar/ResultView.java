package racingcar;

import java.util.List;

public class ResultView {
    public void show(List<Car> cars) {
        for (Car car : cars) {
            int forwardCount = car.forwardCount();

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < forwardCount; i++) {
                builder = builder.append("-");
            }
            System.out.println(builder);
        }
        System.out.println();
    }
}
