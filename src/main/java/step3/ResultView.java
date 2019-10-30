package step3;

import java.util.List;

public class ResultView {

    public void printGame(List<Car> cars, int trialNum) {
        printResultTitle();
        printGameResult(cars, trialNum);
    }

    private void printResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private void printGameResult(List<Car> cars, int trialNum) {
        for (int i = 0; i < trialNum; i++) {
            printCarPositionByRound(cars, i);
            System.out.println();
        }
    }

    private void printCarPositionByRound(List<Car> cars, int roundNum) {
        for (Car car : cars) {
            int carPosition = car.getPosition(roundNum);
            String carPositionBar = getCarPositionBar(carPosition);

            System.out.print(car.getName() + " : ");
            System.out.println(carPositionBar);
        }
    }

    private String getCarPositionBar(int carPosition) {
        StringBuffer carPositionBar = new StringBuffer();
        for (int i = 0; i < carPosition; i++) {
            carPositionBar.append("-");
        }
        return carPositionBar.toString();
    }


}
