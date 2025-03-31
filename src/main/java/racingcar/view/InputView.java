package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.asList(SCANNER.nextLine().split(","));
    }

    public int inputRunCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = Integer.parseInt(SCANNER.nextLine());
        System.out.println();
        return count;
    }
}