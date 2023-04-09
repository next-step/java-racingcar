package racing;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int inputCount() {
        int number = SCANNER.nextInt();
        if(number < 0 ){
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}
