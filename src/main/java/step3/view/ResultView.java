package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {

    private static final String HYPHEN = "-";

    public void output(List<Car> carList) {
        for (Car car : carList) {
            print(car.getPosition());
        }
        System.out.println();
    }

    private void print(int position) {
        String print = "";
        for (int i = 0; i < position; i++) {
            print += HYPHEN;
        }
        System.out.println(print);
    }
}
