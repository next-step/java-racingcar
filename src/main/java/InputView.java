import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getTryCount() {
        System.out.print("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static String[] getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return scanner.nextLine().split(",");
    }
}
