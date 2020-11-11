package racingcar;

import java.util.Scanner;

public class InputView {
    public static int input(String inputMsg){
        System.out.println(inputMsg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
