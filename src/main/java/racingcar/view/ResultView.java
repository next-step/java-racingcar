package racingcar.view;

import racingcar.model.dto.CarDto;

import java.util.List;

public class ResultView implements View {
    private static final String CAR_PATH_EXPRESSION = "-";
    private final List<CarDto> cars;

    public ResultView(List<CarDto> cars) {
        this.cars = cars;
    }

    @Override
    public void render() {
        for (CarDto car : this.cars) {
            int distance = car.distance();
            String format = String.format("%s : %s", car.name(), CAR_PATH_EXPRESSION.repeat(distance));
            System.out.println(format);
        }
        System.out.println();
    }
}
