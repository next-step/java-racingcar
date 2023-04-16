package car.step3;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String scannerCarCertain() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    public String scannerCarNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }
}
