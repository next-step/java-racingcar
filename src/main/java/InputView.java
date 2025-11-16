import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static String readCarNameInput() {
        Scanner scanner = new Scanner(System.in);
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int readRoundCountInput() {
        Scanner scanner = new Scanner(System.in);
        print("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
