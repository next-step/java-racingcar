package view;

import CarRacing.Car;
import CarRacing.Cars;

import java.util.List;

public class ResultView {


    public static void printCarPosition(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        cars.forEach(s -> stringBuilder.append(s.getCarName() + " : " + printPosition(s.getPosition())));
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    public static void printWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }

    private static String printPosition(int position) {
        return new String(new char[position]).replace("\0", "-") + "\n";
    }
}
