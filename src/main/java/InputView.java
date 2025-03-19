import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int scanPositiveInt(String message) {
        System.out.println(message);
        int value = scanner.nextInt();
        scanner.nextLine();
        validatePositiveInt(value);
        return value;
    }

    private void validatePositiveInt(int value) {
        if (value <= 0) {
            String errorMessage = String.format("입력 값은 양수여야 합니다. value:%d", value);
            throw new IllegalArgumentException(errorMessage);
        }
    }

}