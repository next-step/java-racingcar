package step3.view;

import step3.domain.Car;
import step3.domain.Separation;

import java.util.List;

public class ResultView {

    private static final Separation SEPARATION = new Separation();
    private static final String HYPHEN = "-";

    public void output(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + hyphen(car.getPosition()));
        }
        System.out.println();
    }

    public void winnerOutput(List<Car> carList) {
        System.out.println(SEPARATION.winnerSeparation(carList) + " 가 최종 우승했습니다.");
    }

    private String hyphen(int position) {
        String hyphen = "";
        for (int i = 0; i < position; i++) {
            hyphen += HYPHEN;
        }
        return hyphen;
    }
}
