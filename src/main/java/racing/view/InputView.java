package racing.view;

import java.util.Scanner;

public class InputView {
    public static void printQuestion(String question) {
        System.out.println(question);
    }
    
    public static int requireInputInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public static String requestInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static int printQuestionAndGetAnswer(String question) {
        printQuestion(question);
        return requireInputInteger();
    }
}
