package racing.view;

import racing.domain.Car;
<<<<<<< HEAD
import racing.domain.Cars;
=======
import racing.dto.GameResult;
>>>>>>> 583de095d (main 메서드에서 호출할 입력용, 출력용 view 단 클래스 정의)

import java.util.List;

public class ResultView {

<<<<<<< HEAD
    private static void println() {
        System.out.print("\n");
    }

    private static void printName(String input) {
        System.out.print(input + " : ");
    }

    private static void printDash() {
        System.out.print("-");
    }

    public static void printCarsLocations(List<Cars> results) {
        for (int i = 0; i < results.size(); i++) {
            printLocation(results.get(i));
            println();
        }
        println();
    }

    public static void printWinners(List<String> results) {

        for (int i = 0; i < results.size() - 1; i++) {
            System.out.print(results.get(i));
            System.out.print(", ");
        }
        System.out.print(results.get(results.size() - 1));

        System.out.print("가 최종 우승했습니다.");
    }

    private static void printLocation(Cars list) {
        for (int i = 0; i < list.size(); i++) {
            printOnceCar(list.theCar(i));
            println();
        }
    }

    private static void printOnceCar(Car car) {
        printName(car.name());
        for (int i = 0; i < car.location(); i++) {
            printDash();
=======
    public static void printCarsLocations(List<GameResult> results) {
        for (int i = 0; i < results.size(); i++) { // 1회
            printLocation(results.get(i).getResult());
        }
        System.out.println("\n\n");
    }

    private static void printLocation(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            printOnceCar(list.get(i));
            System.out.println("\n");
        }
    }

    private static void printOnceCar(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
>>>>>>> 583de095d (main 메서드에서 호출할 입력용, 출력용 view 단 클래스 정의)
        }
    }
}
