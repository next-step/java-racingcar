package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Console {

    private String userInput;
    private List<String> splitedInput;

    public String readLine() {
        Scanner scanner = new Scanner(System.in);

        setUserInput(scanner.nextLine());
        splitUserInput(userInput);
        return null;
    }

    private void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    private void splitUserInput(String userInput) {
        this.splitedInput = Arrays.asList(userInput.split(" "));
    }

}
