package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        List<Car> cars = new ArrayList<>();
        for (int i=0; i<value; i++) cars.add(new Car());

        System.out.println("시도할 회수는 몇 회 인가요?");
        int number = scanner.nextInt();

        System.out.println();
        System.out.println("실행 결과");
        Driver driver = new Driver(cars);
        for (int i=0; i<number; i++) {
            driver.drive();
            driver.currentDistance();
            System.out.println();
        }
    }
}
