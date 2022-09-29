import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CarRacingInputView {

    public static int getCarCountFromUser() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        try {
            Scanner scanner = new Scanner(System.in);
            return getCarCountInput(scanner);
        } catch (NoSuchElementException e) {
            System.out.println("자동차 수는 양의 정수만 입력 가능합니다.\n");
            return getCarCountFromUser();
        }
    }

    // 쓰임새만 보면 private 처리하고 싶은데, 테스트코드에서 사용해야 해서 public 처리했습니다.
    public static int getCarCountInput(Scanner scanner) throws InputMismatchException {
        int input = scanner.nextInt();
        if (input <= 0) {
            throw new InputMismatchException();
        }
        return input;
    }
}
