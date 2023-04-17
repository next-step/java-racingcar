package racingcar;

import java.util.Scanner;
import java.util.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> carsNameView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        return Arrays.asList(names.split(","));
    }

    public int gameCountView() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
