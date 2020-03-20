package racingcar;

import racingcar.dto.InputType;
import racingcar.dto.InputView;

import java.util.Scanner;

import static racingcar.dto.InputType.CAR;
import static racingcar.dto.InputType.TRY;

public class Question {
    private InputView inputView;

    public Question(InputView inputView) {
        this.inputView = inputView;
    }

    public void generateForTryCount() {
        printQuestion(TRY);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        inputView.insertTryCount(input);
        printBlankSpace();
    }

    public void generateForCarCount() {
        printQuestion(CAR);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        inputView.insertCarCount(input);
        printBlankSpace();
    }

    private void printQuestion(InputType inputType) {
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
