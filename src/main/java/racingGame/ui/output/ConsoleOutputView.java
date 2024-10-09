package racingGame.ui.output;

import racingGame.model.car.Cars;
import racingGame.model.car.CarMovement;
import racingGame.model.car.Car;

import java.util.List;

public class ConsoleOutputView implements OutputView{
    private static final String RESULT_INIT_MESSAGE = "실행결과";
    private static final String POSITION_ICON = "-";
    private static final String NEW_LINE = "\n";

    @Override
    public void printCarGraph(CarMovement carMovementProgress) {
        List<Cars> cars = carMovementProgress.getProgress();

        for (Cars car : cars) {
            printCarGraphByOneStep(car);
        }
    }

    private void printCarGraphByOneStep(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.getCars()) {
            int position = car.getPosition();
            sb.append(POSITION_ICON.repeat(position)).append(NEW_LINE);
        }
        sb.append(NEW_LINE);
        System.out.print(sb);
    }

    @Override
    public void printInitMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(RESULT_INIT_MESSAGE).append(NEW_LINE);
        System.out.print(sb);
    }
}