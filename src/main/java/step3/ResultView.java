package step3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultView {

    public static void displayDash(List<Car> cars) {
        for (Car car : cars) {
            int distance = car.getDistance();
            String carName = car.name;
            System.out.print(carName + " : ");
            printDash(distance);
            System.out.println();
        }
        System.out.println();
    }

    public  static void printDash(int distance) {
        while (distance > 0) {
            System.out.print("-");
            distance--;
        }
    }

    public static void resultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void displayWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }

}
