package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {

    private static final String HYPHEN = "-";

    public void output(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + hyphen(car.getPosition()));
        }
        System.out.println();
    }

    public void winnerOutput(List<Car> carList) {
        for (Car car : carList) {
            System.out.println("우승자 = " + car.getName());
        }
    }

    private String hyphen(int position) {
        String hyphen = "";
        for (int i = 0; i < position; i++) {
            hyphen += HYPHEN;
        }
        return hyphen;
    }
}
