package racing;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputCarCount(){
        System.out.println("자동차 대수는 몇대인가요?");
        return inputCount();
    }

    public int inputTryCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputCount();
    }

    public static int inputCount() {
        int number = SCANNER.nextInt();
        if(number < 0 ){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}
