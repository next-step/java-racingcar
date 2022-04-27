package study.step4.try2.view;

import study.step4.try2.domain.CarNames;
import study.step4.try2.domain.NumberOfAttemps;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputCarNameWithComma() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return CarNames.of(scanner.nextLine()).getCarNames();
    }

    public static int inputNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        return NumberOfAttemps.of(scanner.nextLine()).getNumberOfAttempts();
    }
}
