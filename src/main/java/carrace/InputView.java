package carrace;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int scanCarCount() {
        return repeatScanCount("자동차 대수는 몇 대 인가요?");
    }

    public static int scanTryCount() {
        return repeatScanCount("시도할 회수는 몇 회 인가요?");
    }

    private static int repeatScanCount(String message) {
        int count;
        while(true) {
            try {
                System.out.println(message);
                count = scanCount();
                break;
            } catch (NumberFormatException ex) {
                System.out.println("입력은 숫자만 가능합니다.");
            }
        }
        return count;
    }

    private static int scanCount() {
        return Integer.parseInt(scanner.nextLine());
    }
}
