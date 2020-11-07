package study1.step3;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getCarCnt(){
        return getAnswer("자동차 대수는 몇 대 인가요?");
    }

    public static int getRaceCnt(){
        return getAnswer("시도할 회수는 몇 회 인가요?");
    }

    private static int getAnswer(String text){
        System.out.println(text);
        return validateNumber(scanner.nextInt());
    }

    public static int validateNumber(int inputNumber){
        if (inputNumber <= 0){
            throw new IllegalArgumentException("0보다 큰 숫자를 입력부탁드립니다.");
        }
        return inputNumber;
    }
}
