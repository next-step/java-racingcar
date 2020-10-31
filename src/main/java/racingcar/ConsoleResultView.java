package racingcar;

import java.util.List;

public class ConsoleResultView implements ResultView {
    @Override
    public void print(List<RacingCar> cars) {
        StringBuilder sb = new StringBuilder();

        for (RacingCar car : cars) {
            for (int i = 0; i < car.getMoveCount(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
