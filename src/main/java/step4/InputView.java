package step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public InputDto getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.next().split(",");
        List<String> nameList = new ArrayList<>(Arrays.asList(names));

        System.out.println("시도할 회수는 몇 회 인가요?");
        int trial = scanner.nextInt();

        return new InputDto(nameList, trial);
    }
}
