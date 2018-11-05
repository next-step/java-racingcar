package racinggame.ui;

import racinggame.model.Car;

import java.util.Iterator;
import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String COMMA = ",";

    public static void printResultRacing(List<Car> carList) {
        carList.forEach(car -> printDash(car));
        System.out.println();
    }

    public static void printRacingWinner(List<String> racingGameWinnerList) {
        Iterator<String> iteratorWinner = racingGameWinnerList.iterator();

        while(iteratorWinner.hasNext()) {
            System.out.print(iteratorWinner.next());

            printComma(iteratorWinner);
        }

        System.out.println("가 최종 우승했습니다.");
    }

    protected static void printDash(Car car) {
        System.out.print(car.getName() + " : ");

        for(int i = 0; i < car.getPosition(); i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }

    protected static void printComma(Iterator<String> iteratorWinner) {
        if(iteratorWinner.hasNext()) {
            System.out.print(COMMA);
        }
    }
}
