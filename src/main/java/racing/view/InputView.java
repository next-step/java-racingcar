package racing.view;

import racing.vo.GameMakingInfo;

import java.util.Scanner;

import static racing.common.Script.CAR_NAMES_QUESTION;
import static racing.common.Script.TIME_COUNT_QUESTION;

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
    
    private String printCarQuestionAndGetAnswer() {
        printQuestion(CAR_NAMES_QUESTION.getMessage());
        return requestInputString();
    }
    
    private int printTimeQuestionAndGetAnswer() {
        printQuestion(TIME_COUNT_QUESTION.getMessage());
        return requireInputInteger();
    }
    
    public GameMakingInfo requestGameInfo() {
        return new GameMakingInfo(printCarQuestionAndGetAnswer(), printTimeQuestionAndGetAnswer());
    }
}
