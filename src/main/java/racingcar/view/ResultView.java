package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView implements View {
    private static final String CAR_PATH_EXPRESSION = "-";
    private final List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void render() {
        for (Car car : this.cars) {
            int distance = car.distance();
            System.out.println(CAR_PATH_EXPRESSION.repeat(distance));
        }
        System.out.println();
    }
}
