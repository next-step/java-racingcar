package CarRacing;

import java.util.Scanner;

public class NumberInputScanner {

    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    public int getNumber() {
        if(number <= 0) {
            throw new IllegalArgumentException("Input number should be more than 0");
        }
        return number;
    }
}
