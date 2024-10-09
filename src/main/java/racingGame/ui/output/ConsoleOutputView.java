package racingGame.ui.output;

import racingGame.model.car.Cars;
import racingGame.model.car.CarMovement;
import racingGame.model.car.Car;

import java.util.List;

public class ConsoleOutputView implements OutputView{
    private static final String RESULT_INIT_MESSAGE = "실행결과";
    private static final String POSITION_ICON = "-";
    private static final String NEW_LINE = "\n";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String RESULT_WINNERS_POSTFIX_MESSAGES = "가 최종 우승했습니다.";

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
            sb.append(car.getName());
            sb.append(NAME_POSITION_SEPARATOR);
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

    @Override
    public void printWinners(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(car.getName());
        }
        sb.append(RESULT_WINNERS_POSTFIX_MESSAGES);
        System.out.println(sb);
    }
}