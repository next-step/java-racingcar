package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView implements ConsoleView {
    private Scanner scanner;
    private List<String> questionList;
    private int questionPosition;

    public InputView(List<String> questionList) {
        scanner = new Scanner(System.in);
        this.questionPosition = 0;
        this.questionList = questionList;
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    public String questionStepByStep() {
        this.print(questionList.get(this.questionPosition++));
        return this.scanner.nextLine();
    }
}
