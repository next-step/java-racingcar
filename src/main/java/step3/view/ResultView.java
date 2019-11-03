package step3.view;

import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int POSITION = 1;
    private static List<String> winners = new ArrayList<>();

    public static void printCar(List<Car> cars) {

        for (Car car : cars) {
            printName(car.getName());
            printPositionsView(car.getPosition());
        }
        System.out.println();
    }


    private static void printPositionsView(List<Integer> positions) {
        for (int i = 0; i < positions.size(); i++) {
            printBar(positions.get(i));
        }
        System.out.println();
    }

    private static void printBar(int position) {
        if (position == POSITION) {
            System.out.print("- ");
        }
    }

    private static void printName(String name) {
        System.out.print(name + " : ");
    }

    public static void getWinners(String winner) {
        winners.add(winner);
    }

    public static void printWinner() {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}