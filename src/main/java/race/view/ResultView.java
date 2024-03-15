package race.view;

import race.domain.Car;

import java.util.List;

public class ResultView {

    private static final String FORWARD_SIGN = "-";

    public void printResult() {
        System.out.println("실행 결과\n");
    }

    public void showResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(FORWARD_SIGN.repeat(carList.get(i).getPosition()));
        }
        System.out.println();
    }
}
