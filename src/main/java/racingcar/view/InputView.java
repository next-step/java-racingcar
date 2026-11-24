package racingcar.view;

import racingcar.domain.TryCount;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return NameParser.parse(SCANNER.nextLine());
    }

    public static TryCount getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return TryCountParser.parse(SCANNER.nextLine());
    }
}
