package step2;

import java.util.List;

public class ResultView {

    public void printGame(List<Car> carList, int trialNum) {
        printResultTitle();
        printGameResult(carList, trialNum);
    }

    private void printResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private void printGameResult(List<Car> carList, int trialNum){
        for (int i = 0; i < trialNum; i++) {
            printCarPositionByRound(carList, i);
            System.out.println();
        }
    }

    private void printCarPositionByRound(List<Car> carList, int roundNum) {
        for (Car car : carList) {
            int carPosition = car.getCarPosition(roundNum);
            String carPositionBar = getCarPositionBar(carPosition);
            System.out.println(carPositionBar);
        }
    }

    private String getCarPositionBar(int carPosition){
        StringBuffer carPositionBar = new StringBuffer();
        for (int i = 0; i < carPosition; i++) {
            carPositionBar.append("-");
        }
        return carPositionBar.toString();
    }


}
