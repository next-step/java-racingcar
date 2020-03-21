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
        inputView.insertCarNames(input);
        printBlankSpace();
    }

    private void printQuestion(InputType inputType) {
        if (CAR.equals(inputType)) {
            System.out.println("자동차 이름을 입력하세요, (단, 자동차 이름은 쉼표(,)로 구분해야 합니다.)");
        }
        if (TRY.equals(inputType)) {
            System.out.println("몇 회를 시도하실 건가요?");
        }
    }

    private void printBlankSpace() {
        System.out.println();
    }
}
