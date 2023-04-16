package car;

import java.util.Scanner;

public class InputView {

    public int inputValue(){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return Integer.valueOf(value);
    }

}
