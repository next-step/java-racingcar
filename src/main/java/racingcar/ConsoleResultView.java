package racingcar;

import java.util.List;

public class ConsoleResultView implements ResultView {
    @Override
    public void print(List<RacingCar> cars) {
        StringBuilder sb = new StringBuilder();

        for (RacingCar car : cars) {
            car.printProcess(sb);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
