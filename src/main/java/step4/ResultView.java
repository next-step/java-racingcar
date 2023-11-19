package step4;

import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println("\n실행 결과");
    }

    public void makeResultView(List<Car> carList) {

        for (int i = 0; i < InputView.getTryCnt(); i++) {
            getResultView(carList);
            System.out.println();
        }
    }

    private static void getResultView(List<Car> carList) {
        for (Car car : carList) {
            StringBuilder sb = new StringBuilder();
            car.move();
            System.out.println(sb.append(car.name + " : ").append("-".repeat(car.getDistance())));
        }
    }

    public void printWinners(String getWinnerNames) {
        System.out.println(getWinnerNames+"가 최종 우승했습니다.");
    }
}
