package racingcar;

import java.util.Scanner;

import static racingcar.InputType.CAR;
import static racingcar.InputType.TRY;

public class Question {
    private InputView inputView;
    private InputType inputType;

    public Question(InputView inputView, InputType inputType) {
        this.inputView = inputView;
        this.inputType = inputType;
    }

    public void generate() {
        printQuestion();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        inputView.insertNumberIntoField(input, inputType);
        printBlankSpace();
    }

    private void printQuestion() {
        if (CAR.equals(inputType)) {
            System.out.println("몇 대의 자동차로 게임을 진행하실 건가요?");
        }
        if (TRY.equals(inputType)) {
            System.out.println("몇 회를 시도하실 건가요?");
        }
    }

    private void printBlankSpace() {
        System.out.println();
    }
}
