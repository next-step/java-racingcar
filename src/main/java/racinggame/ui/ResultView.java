package racinggame.ui;

import racinggame.model.Car;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String COMMA = ",";

    public static void printResultRacing(List<Car> carList) {
        carList.forEach(car -> printDash(car));
        System.out.println();
    }

    public static void printRacingWinner(List<String> racingGameWinner) {
        String winners = String.join(COMMA, racingGameWinner);
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    protected static void printDash(Car car) {
        System.out.print(car.getName() + " : ");

        for(int i = 0; i < car.getPosition(); i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }
}
