package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        return split(carNames);
    }

    private List<String> split(String carNames) {
        List<String> resultNames = new ArrayList<>();
        String[] splitNames = carNames.split(",");
        for (String carName : splitNames) {
            resultNames.add(carName.trim());
        }
        return resultNames;
    }

    public int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int inputOpportunity() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int opportunity = scanner.nextInt();
        System.out.println();
        return opportunity;
    }
}
