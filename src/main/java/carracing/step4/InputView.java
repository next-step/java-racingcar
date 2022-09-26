package carracing.step4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        return Arrays.asList(names.split(","));
    }

    public int enterTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = scanner.nextLine();
        return Integer.parseInt(tryCount);
    }

}
