package racingcar.view;

import racingcar.entity.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String COMMA_SEPARATOR = ",";

    public static List<Name> requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] split = scanner.nextLine().split(COMMA_SEPARATOR);
        return Arrays.stream(split).map(name -> new Name(name)).collect(Collectors.toList());
    }

    public static int requestTryNumber() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
