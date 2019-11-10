package step3.racingcarWinner.view;

import step3.racingcarWinner.domain.Car;
import step3.racingcarWinner.domain.RacingGame;

import java.util.List;

public class ResultView {

    private RacingGame racingGame;

    private String winner = "";

    public ResultView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public static List<Car> printCurrentCarListPosition(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            printCurrentCarPosition(carList.get(i));
        }
        System.out.println("");
        return carList;
    }

    public static void printCurrentCarPosition(Car car) {
        System.out.println("");
        System.out.print(car.getName() + ":");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public void printFinalWinner(List<Car> carList) {
        for (Car car : carList) {
            appendWinner(car);
        }
        System.out.println(winner + "가 최종 우승했습니다.");
    }

    private void appendWinner(Car car) {
        if (car.isFinalWinner()) {
            generateWinnerText(car.getName());
        }
    }

    private void generateWinnerText(String name) {
        if (!winner.equals("")) {
            winner += ", " + name;
        }

        if (winner.equals("")) {
            winner += name;
        }
    }
}
