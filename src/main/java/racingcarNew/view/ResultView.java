package racingcarNew.view;

import racingcarNew.domain.Car;
import racingcarNew.domain.Cars;
import racingcarNew.domain.RacingHistory;

import java.util.List;

public class ResultView {

    private RacingHistory racingHistory;

    public ResultView(RacingHistory racingHistory) {
        this.racingHistory = racingHistory;
    }

    public void printRacingHistory() {
        System.out.println(" ");
        System.out.println("실행 결과");
        for (Cars cars : racingHistory.getCarsHistory()) {
            printCarsHistory(cars);
        }
    }

    private void printCarsHistory(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getCarName() + " : ");
            printCarPosition(car);
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    private void printCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public void printStatistic(int racingLap) {
        Cars lastLapCars = racingHistory.getLastCarsHistory(racingLap);
        List<Car> winners = lastLapCars.getWinners();
        printWhoIsWinner(winners);
    }

    private void printWhoIsWinner(List<Car> winners) {
        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            resultText.append(printWinners(i, winners.get(i)));
        }
        System.out.println(resultText + "가 최종 우승했습니다.");
    }

    private String printWinners(int i, Car car) {
        String returnText = car.getCarName();
        if (i > 0) {
            returnText = "," + car.getCarName();
        }
        return returnText;
    }
}
