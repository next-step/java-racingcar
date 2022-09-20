package racing_car.step3.domain.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static int inputNum() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return SCANNER.nextInt();
    }
}
