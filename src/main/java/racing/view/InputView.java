package racing.view;

import java.util.Scanner;

public class InputView {
    private final static String QUESTION_CAR = "자동차 대수는 몇 대 인가요?";
    private final static String QUESTION_TIME = "시도할 회수는 몇 회 인가요?";
    
    public void printQuestionCar() {
        System.out.println(QUESTION_CAR);
    }
    
    public void printQuestionTime() {
        System.out.println(QUESTION_TIME);
    }
    
    public int requireInputInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
