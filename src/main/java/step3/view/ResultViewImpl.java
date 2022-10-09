package step3.view;

import step3.model.Cars;

public class ResultViewImpl implements ResultView {
    private static final String MOVEMENT = "-";

    @Override
    public void drawResult(Cars carList) {
        carList.getCars().stream().map(car -> MOVEMENT.repeat(car.getMoveCnt())).forEachOrdered(System.out::println);
        System.out.println();
    }
}
