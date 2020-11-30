package lotto.stringsumcalculator.view;

import java.util.Scanner;

public class InputView {

    public static String inPutString(){
        System.out.println("합을 구할 문자열을 입력해주세요.");
        return new Scanner(System.in).nextLine();
    }
}
