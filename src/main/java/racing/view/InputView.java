package racing.view;

import racing.core.ClientInput;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    private static final String CAR_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_QUESTION = "시도할 회수는 몇 회 인가요?";

    public ClientInput getClientInput() {
        ClientInput result;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(CAR_QUESTION);
            String carNames = scanner.nextLine();
            System.out.println(TRY_QUESTION);
            int tryCount = scanner.nextInt();
            result = ClientInput.builder()
                    .carNames(carNames)
                    .tryCount(tryCount)
                    .build();
        } finally {
            scanner.close();
        }
        return result;
    }

}
