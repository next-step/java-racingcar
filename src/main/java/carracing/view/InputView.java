package carracing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userInput = scanner.nextLine();

        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toUnmodifiableList());

    }

    public int getRoundNumberFromUser() {
        System.out.println("시도할 회수는 몇 회 인가요? : ");
        return Integer.parseInt(scanner.nextLine());
    }

}
