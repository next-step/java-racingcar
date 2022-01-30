package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racing.domain.TryNumber;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    private InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(SCANNER.nextLine().split(COMMA))
            .map(name -> name.trim())
            .collect(Collectors.toList());
    }

    public static TryNumber getTryNumber() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            final int tryNumber = Integer.parseInt(SCANNER.nextLine());
            return new TryNumber(tryNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("[ERROR] 숫자만 입력 해주세요.");
            return getTryNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryNumber();
        }
    }
}
