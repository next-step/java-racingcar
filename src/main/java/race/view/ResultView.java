package race.view;

import race.domain.Car;

import java.util.List;

public class ResultView {

    private static final String FORWARD_SIGN = "-";

    public void printResult() {
        System.out.println("실행 결과\n");
    }

    public void showResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName()+" : "+FORWARD_SIGN.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void showWinners(List<String> winnerNames) {
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }

}
