package carracing.domain.scanner;

import java.util.Scanner;

public class NumberInputScanner {

    private int MIN_INPUT_VALUE = 0;
    private int number;

    private void getInputStream() {
        Scanner scanner = new Scanner(System.in);
        this.number  = scanner.nextInt();
    }

    public int getNumber() {
        getInputStream();
        if(number <= MIN_INPUT_VALUE) {
            throw new IllegalArgumentException("Input number should be more than 0");
        }
        return number;
    }
}
