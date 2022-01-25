package calculator.view;

import java.util.Scanner;

public class UserInput {

    final private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        System.out.println("식을 입력하세요");
        return scanner.nextLine();
    }
}
