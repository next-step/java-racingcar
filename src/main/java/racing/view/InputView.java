package racing.view;

import java.util.Scanner;

public class InputView {
    public void printQuestion(String question) {
        System.out.println(question);
    }
    
    public int requireInputInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public String requestInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
