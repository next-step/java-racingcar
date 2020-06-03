package step5.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private String delimiter = ",";

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼포(,)를 기준으로 구분).");
        return Arrays.asList(scanner.next().split(delimiter));
    }

    public int inputPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

}
