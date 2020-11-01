package racingcar;

import java.util.Scanner;

public class InputView {
    public static int Input(String inputMsg){
        System.out.println(inputMsg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
