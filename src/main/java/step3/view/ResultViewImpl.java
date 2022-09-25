package step3.view;

import step3.model.Car;

import java.util.List;

public class ResultViewImpl implements ResultView {
    private static final String MOVEMENT = "-";

    @Override
    public void drawResult(List<Car> carList) {
        carList.stream().map(car -> MOVEMENT.repeat(car.getMoveCnt())).forEachOrdered(System.out::println);
        System.out.println();
    }
}
