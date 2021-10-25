package racingcar.views;

import racingcar.domains.Car;
import racingcar.domains.Cars;

import java.util.List;

public class ResultView {

    public void printRacingResult(List<Cars> racingResult) {
        System.out.println("실행 결과");

        for (Cars cars : racingResult) {
            printRacingResultPerRound(cars);
        }

    }

    private void printRacingResultPerRound(Cars cars) {
        for (Car car : cars.getCars()) {

            StringBuilder sb = new StringBuilder(car.getName());
            sb.append(" : ");
            sb.append(getCarPositionStr(car.getPosition()));

            System.out.println(sb.toString());
        }
        System.out.println();
    }

    private String getCarPositionStr(int position) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void printRacingWinner(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
