package step3;

import java.util.Scanner;

public class EnterGameConfig {
    private final Scanner scanner = new Scanner(System.in);

    public int enterCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = Integer.parseInt(this.scanner.nextLine());
        return carNumber;
    }

    public int enterIterate() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int iterate = Integer.parseInt(this.scanner.nextLine());
        this.inputClose();
        return iterate;
    }

    private void inputClose() {
        this.scanner.close();
    }
}
