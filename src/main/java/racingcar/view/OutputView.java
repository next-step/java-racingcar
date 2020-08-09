package racingcar.view;

import racingcar.car.Car;
import java.util.List;
import static java.lang.System.*;

public class OutputView {
    public static void printCarStatus(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder track = new StringBuilder();
            for(int i=1; i <= car.getStatus(); i++) {
                track.append("-");
            }
            out.println(track);
        });
    }
}
