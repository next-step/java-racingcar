import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getAnswerToInteger(String question) {
        while (true) {
            System.out.println(question);
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("유효하지 않은 타입입니다.");
            }
        }
    }
}
