package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static final String GAME_RESULT_MESSAGE = "실행 결과";

    public OutputView() {}

    public void view(List<Car> cars) {
        Output output;
        for (Car car : cars) {
            output = new Output();
            // TODO : 디미터법칙
            System.out.print(car.getName().toString() + " : ");
            output.mappingToBar(car.currentDistance().toInt());
            print(output.getBar());
        }
        nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void nextLine() {
        System.out.println();
    }
}
