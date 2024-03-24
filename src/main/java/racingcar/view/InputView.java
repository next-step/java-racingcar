package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public List<String> names() {
        System.out.println("자동차들의 이름을 입력하세요(','로 구분): ");
        String names = scanner.nextLine();
        List<String> splitNames = Arrays.asList(names.split(",", -1));
        return splitNames;
    }

    public int opportunity() {
        System.out.println("경주 진행 횟수를 입력하세요: ");
        return scanner.nextInt();
    }
}
