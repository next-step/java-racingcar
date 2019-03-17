package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public static void print(String out) {
        System.out.print(out);
    }

    public static void println(String out) {
        System.out.println(out);
    }

    public static void printRoundResult(List<Car> cars) {
        for(Car car : cars) {
            printPosition(car.getPosition(), car.getName());
        }
        println("");
    }

    public static void printPosition(int position, String name) {
        System.out.print(name + " : ");
        for (int dash = 0; dash < position; dash++) {
            System.out.print("-");
        }
        println("");
    }

    public static void announceWinner(List<String> winners) {
        println("우승자를 발표하겠습니다!!");
        print("우승자는 " + parsingWinners(winners));
        print("입니다. 축하합니다!");
    }

    private static String parsingWinners(List<String> winners) {
        String resultString = "";
        for(String winner : winners) {
            resultString += winner + ", ";
        }
        return resultString.substring(0, resultString.length()-2);
    }
}