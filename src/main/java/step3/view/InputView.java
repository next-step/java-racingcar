package step3.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getCarNumberFromUser() {
        System.out.print("자동차 대수는 몇 대 인가요? : \n");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getRoundNumberFromUser() {
        System.out.print("시도할 회수는 몇 회 인가요? : \n");
        return Integer.parseInt(scanner.nextLine());
    }

}
