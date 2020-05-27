package racing.view;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RacingGameResult;

import java.util.List;

public class ResultView {

    public ResultView(String message) {
        System.out.println(message);
    }

    public void print(List<RacingCars> allRoundRacingCars) {
        for (RacingCars racingCars : allRoundRacingCars) {
            printRoundPosition(racingCars.getCarList());

            System.out.println();
        }
    }

    private void printRoundPosition(List<Car> carList) {
        for (Car car : carList) {
            drawCarPosition(car);
        }
    }

    private void drawCarPosition(Car car) {
        StringBuilder paper = new StringBuilder(car.getName());
        paper.append(" : ");
        int position = car.getPosition();

        for (int i = 0; i < position; i++) {
            paper.append("-");
        }

        System.out.println(paper.toString());
    }

    public void printFinalWinner(String winners) {
        System.out.println(winners + "가 최종 우승하였습니다.");
    }
}
