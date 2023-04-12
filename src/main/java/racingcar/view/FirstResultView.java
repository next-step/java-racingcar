package racingcar.view;

import racingcar.model.dto.CarDto;

import java.util.List;

public class FirstResultView extends ResultView {
    public FirstResultView(List<CarDto> cars) {
        super(cars);
    }

    @Override
    public void render() {
        System.out.println("\n실행 결과");
        super.render();
    }
}
