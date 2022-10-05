package step3;
import java.util.ArrayList;
import java.util.Scanner;

public class ResultView {

    public static void displayDash(ArrayList<Car> cars) {
        for (Car car : cars) {
            int distance = car.getDistance();
            while (distance > 0) {
                System.out.print("-");
                distance--;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void resultMessage() {
        System.out.println("\n실행 결과");
    }

}
