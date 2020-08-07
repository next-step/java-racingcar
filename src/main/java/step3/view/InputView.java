package step3.view;

import java.util.Scanner;

public class InputView {
    public static int cars;
    public static int tries;

    public static void initShow() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        cars = inputCome();

        System.out.println("시도할 회수는 몇 회 인가요?");
        tries = inputCome();

        System.out.println("\n실행 결과");
    }

    public static int inputCome(){
        Scanner sc = new Scanner(System.in);

        int input;

        try{
           input=sc.nextInt();
           return input;
        }catch (IllegalArgumentException e){
           System.out.println("정수만 입력가능합니다");
           e.printStackTrace();
        }
        return -1;
    }
}
