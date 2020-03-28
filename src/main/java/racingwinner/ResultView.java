package racingwinner;

import java.util.List;

public class ResultView {
    private RacingGame racingGame;


    public ResultView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public static void printResult(Car car) {
        System.out.print(car.name + " : ");
        for (int i = 0; i < car.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        System.out.print(winners.get(0).name);
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", " + winners.get(i).name);
        }
        System.out.print("가 최종 우승했습니다");
    }
}
