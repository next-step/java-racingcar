package common;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER =  new Scanner(System.in);

    public static int nextInt(String message){
        System.out.println(message);
        return SCANNER.nextInt();
    }

}
