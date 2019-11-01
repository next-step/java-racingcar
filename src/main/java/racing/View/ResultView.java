package racing.View;

import racing.game.Car;

import java.util.List;

public class ResultView {

    public void printGame(List<Car> cars, int totalRound, List<String> winners) {
        printResultTitle();
        printGameResult(cars, totalRound);
        printWinners(winners);
    }

    private void printResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private void printGameResult(List<Car> cars, int totalRound) {
        for (int i = 0; i < totalRound; i++) {
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

    private void printWinners(List<String> winners) {
        System.out.print(String.join(",", winners) + "이(가) 최종 우승했습니다.");
    }

}
