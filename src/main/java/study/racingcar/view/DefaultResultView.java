package study.racingcar.view;

import study.racingcar.car.Car;

import java.util.List;

public class DefaultResultView implements ResultView {

    @Override
    public void displayResult(List<Car> cars) {
        cars.stream().forEach(this::drawCarPosition);
    }

    private void drawCarPosition(Car car) {
        for (int position = 0; position < car.getCurrentPosition(); position++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
