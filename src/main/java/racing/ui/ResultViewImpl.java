package racing.ui;

import racing.domain.Car;

public class ResultViewImpl implements ResultView {

    public ResultViewImpl() {
        System.out.println("실행 결과");
    }

    @Override
    public void print(Car car) {
        System.out.println(car.getMoved());
    }

}
