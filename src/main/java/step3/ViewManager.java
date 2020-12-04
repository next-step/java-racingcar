package step3;

import java.util.List;
import java.util.Scanner;

public class ViewManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMessageAboutCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int inputMessageAboutTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static void outputMessageAboutMove(List<Driver> drivers, int numOfTry) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i=0; i<numOfTry; i++) {
            drivers.stream().forEach(driver -> driver.drive(RandomGenerator.generate()));
            System.out.println();
        }
    }
}
