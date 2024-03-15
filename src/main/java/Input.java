import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    private View view = new View();

    public int inputCar() throws Exception {
        view.inputCarView();
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("유효하지 않은 입력입니다. 숫자만 입력하세요");
        }
    }

    public int inputTry() throws Exception {
        view.inputTryView();
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("유효하지 않은 입력입니다. 숫자만 입력하세요");
        }
    }
}
