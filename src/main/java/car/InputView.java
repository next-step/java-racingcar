package car;

import java.util.Scanner;

public class InputView {
    public static Integer inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
