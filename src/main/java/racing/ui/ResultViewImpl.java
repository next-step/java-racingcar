package racing.ui;

import racing.domain.Car;

public class ResultViewImpl implements ResultView {

    private static final String BEGIN_TEXT = "실행 결과";

    public ResultViewImpl() {
        System.out.println(BEGIN_TEXT);
    }

    @Override
    public void print(Car car) {
        System.out.println(car.getMoved());
    }

}
