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

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return SCANNER.nextLine();
    }

    public static int inputCount() {
        int number = SCANNER.nextInt();
        if(number < 0 ){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}
