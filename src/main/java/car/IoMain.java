package car;

import java.util.List;
import java.util.Scanner;

public class IoMain {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Car> cars = CarService.generate(carIO());
        int moveCount = moveIO();

        System.out.println("\n실행 결과");

        for (int i = 0; i < moveCount; i++) {
            CarService.repeatMove(cars);
            showMark(cars);
        }

    }

    public static int carIO() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public static int moveIO() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }

    private static void showMark(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getMark());
        }
        System.out.println();
    }

}
