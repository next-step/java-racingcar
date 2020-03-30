package racingGame.view;

import racingGame.domain.Car;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> allCars) {
        for(Car car : allCars) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public static void printPosition(int position) {
        for(int posIdx = 0; posIdx < position; posIdx++) {
            System.out.print("-");
        }
    }

    public static void printWinner(List<String> winners) {
        System.out.print(winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", " + winners.get(i));
        }
        System.out.print("가 최종 우승했습니다");
    }
}
