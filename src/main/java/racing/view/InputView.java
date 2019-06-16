package racing.view;

import java.util.Scanner;

public class InputView {
    public static void printQuestion(String question) {
        System.out.println(question);
    }
    
    public static int getIntAnswer() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        return scanner.nextInt();
    }
    
    public static String getStringAnswer() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        return scanner.nextLine();
    }
}
