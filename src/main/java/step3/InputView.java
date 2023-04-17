package step3;

import java.util.Scanner;

public class InputView {
    public static int inputInfo(){
        Scanner sc = new Scanner(System.in);
        int inputNum = 0;
        while(true) {
            try {
                inputNum = inputCheck(sc.nextInt());
                break;
            }catch (NumberFormatException e) {
                System.out.println("2이상의 정수값을 입력해주세요.\n");
            }
        }
        return inputNum;
    }

    public static int inputCheck(int input){
        if (input < 2) {
            throw new NumberFormatException();
        }
        return input;
    }
}
