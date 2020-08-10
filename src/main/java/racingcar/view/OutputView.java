package racingcar.view;

import racingcar.car.Car;
import java.util.List;
import static java.lang.System.*;
import static racingcar.racing.Racing.moveCarForward;
import static racingcar.random.GenerateRandom.randomForward;

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

    public static void resultView(List<Car> cars, int tryCount) {
        out.println("실행 결과");
        for(int i=0; i < tryCount; i++) {
            cars = moveCarForward(cars, randomForward());
            printCarStatus(cars);
            out.println();
        }
    }
}
