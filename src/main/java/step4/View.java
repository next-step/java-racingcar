package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        List<Driver> drivers = new ArrayList<>();
        for (int i=0; i<value; i++) drivers.add(new Driver());

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numOfTry = scanner.nextInt();

        System.out.println();
        System.out.println("실행 결과");
        for (int i=0; i<numOfTry; i++) {
            drivers.stream().forEach(driver -> driver.drive(step4.RandomGenerator.generate()));
            System.out.println();
        }
    }
}
