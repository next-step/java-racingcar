package racing.view;

import java.util.Scanner;

public class InputView {
    public void printQuestion(String question) {
        System.out.println(question);
    }
    
    public int requireInputInteger() {
        return new Scanner(System.in).nextInt();
    }
    
    public String requestInputString() {
        return new Scanner(System.in).nextLine();
    }
}
