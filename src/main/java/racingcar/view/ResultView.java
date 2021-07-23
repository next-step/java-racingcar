package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

/*
 * 자동차 경주 결과 View
 */
public class ResultView {
    public void print(String carname, int move) {
        System.out.print(carname + ":");
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void getWinner(List<Car> winners) {
        StringBuilder winnerText = new StringBuilder();

        for (Car winner : winners) {
            winnerText.append(winner.getName()).append(" ");
        }
        System.out.println("우승자는 " + winnerText + "입니다.");
    }

}
