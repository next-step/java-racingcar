package racingcar.resultview;

import racingcar.domain.RacingCar;

import java.util.List;

public class ConsoleResultView implements ResultView {
    @Override
    public void print(List<RacingCar> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (RacingCar car : cars) {
            car.printProcess(stringBuilder);
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
