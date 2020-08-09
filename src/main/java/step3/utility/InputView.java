package step3.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    static final String QUESTION_CAR_NUMBER= "자동차 대수는 몇 대 인가요?";
    static final String QUESTION_TRY_NUMBER= "시도할 회수는 몇 회 인가요?";
    static final String RESULT = "\n실행 결과";

    public static UserInput initShow() {
        System.out.println(QUESTION_CAR_NUMBER);
        int cars = inputCome();

        System.out.println(QUESTION_TRY_NUMBER);
        int tries = inputCome();

        System.out.println(RESULT);
        return new UserInput(cars,tries);
    }

    public static int inputCome(){
        Scanner sc = new Scanner(System.in);

        int input;

        try{
           input=sc.nextInt();
           return input;
        }catch (InputMismatchException e){
            e.printStackTrace();
            throw new IllegalArgumentException("정수만 입력가능합니다");
        }
    }
}
