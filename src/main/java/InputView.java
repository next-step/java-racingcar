import javax.xml.transform.Result;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getAnswerToInteger(String question) {
        while (true) {
            ResultView.println(question);
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                ResultView.printTypeError();
            }
        }
    }

    public static String[] getCarNames() {
        while (true) {
            ResultView.askCarNames();
            try {
                String str = scanner.next();
                return str.split(",");
            } catch (Exception e) {
                ResultView.printTypeError();
            }
        }
    }
}
