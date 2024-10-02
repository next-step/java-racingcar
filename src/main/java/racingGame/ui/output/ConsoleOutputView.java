package racingGame.ui.output;

import racingGame.model.car.Car;

import java.util.List;

public class ConsoleOutputView implements OutputView{
    private static final String RESULT_INIT_MESSAGE = "실행결과";
    private static final String POSITION_ICON = "-";

    @Override
    public void printCarGraph(List<Car> cars) {
        for (Car car : cars) {
            int position = car.getPosition();
            System.out.println(POSITION_ICON.repeat(position));
        }
        System.out.println();
    }

    @Override
    public void printInitMessage() {
        System.out.println(RESULT_INIT_MESSAGE);
    }
}
