package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return Arrays.asList(scanner.nextLine().split(",")).stream()
            .map(s -> s.trim())
            .collect(Collectors.toList());
    }

    public int requestTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
