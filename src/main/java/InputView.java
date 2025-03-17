import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getAnswerToInteger(String question) {
        int num = 0;
        while (true) {
            try {
                System.out.println(question);
                num = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("유효하지 않은 타입입니다.");
            }
        }
        return num;
    }
}
