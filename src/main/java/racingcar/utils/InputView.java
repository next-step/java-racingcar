package racingcar.utils;

import racingcar.domain.PositiveNumber;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static PositiveNumber inputNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();

        return PositiveNumber.create(inputText);
    }

    public static List<String> inputString() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();

        return List.of(inputText.split(","));
    }
}
