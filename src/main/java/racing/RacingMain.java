package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int carCount;
        int gameCount;

        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        gameCount = sc.nextInt();

        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }

        System.out.print("실행결과");

        for (int i = 0; i < gameCount; i++) {
            for (Car car : carList) {
                car.move();
                System.out.println();
                car.printResult();
            }
            System.out.println();
        }

        System.out.println();

    }
}
