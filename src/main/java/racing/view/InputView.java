package racing.view;

import java.util.Scanner;

public class InputView {
    private static void printQuestion(String question) {
        System.out.println(question);
    }
    
    private static int requireInputInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public static int printQuestionAndgetAnswer(String question) {
        printQuestion(question);
        return requireInputInteger();
    }
}
