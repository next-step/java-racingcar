import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView () {
        this.scanner = new Scanner(System.in);
    }

    private int validationArgument(String value){
        if (!GameCondition.isInteger(value)) {
            throw new IllegalArgumentException("정수 형태의 숫자만 입력이 가능합니다.");
        }
        return Integer.parseInt(value);
    }

    public int inputIntArgument(String description) {
        System.out.println(description);
        return validationArgument(scanner.nextLine());
    }
}
