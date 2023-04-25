package step3.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static String inputString(String text) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }

    public static int input(String text) {

        int inputValue = 0;
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println(text);
            inputValue = scanner.nextInt();;
        }catch (InputMismatchException e){
            System.out.println("숫자 외에는 입력할 수 없습니다.");
            inputValue = input(text);
        }
        return inputValue;

    }
}
