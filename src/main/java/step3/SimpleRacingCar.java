package step3;

import java.util.Scanner;

public class SimpleRacingCar {
    public static int carCnt = 0;
    public static int repeatCnt = 0;

    public static void main(String[] args) {
        racingInfoInput();
    }

    public static void racingInfoInput(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("자동차 대수는 몇 대 인가요?");
                carCnt = inputCheck(sc.nextInt());

                System.out.println("시도할 회수는 몇 회 인가요?");
                repeatCnt = inputCheck(sc.nextInt());

                break;
            }catch (NumberFormatException e) {
                System.out.println("2이상의 정수값을 입력해주세요.\n");
            }
        }
    }

    public static int inputCheck(int input){
        if (input < 2) {
            throw new NumberFormatException();
        }
        return input;
    }
}
