package step3.view;

import java.util.Scanner;

public class InputView {

    public int inputValue(String question) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextInt();

    }
}
