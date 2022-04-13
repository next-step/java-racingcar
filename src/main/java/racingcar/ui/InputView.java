package racingcar.ui;

import racingcar.domain.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static List<CarName> promptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = SCANNER.next().split(",");

        return Arrays.stream(names)
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    public static int promptRounds() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }
}
