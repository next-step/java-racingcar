package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class FirstResultView extends ResultView {
    public FirstResultView(List<Car> cars) {
        super(cars);
    }

    @Override
    public void render() {
        System.out.println("\n실행 결과");
        super.render();
    }
}
