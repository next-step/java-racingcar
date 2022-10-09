package racing.view;

import racing.core.ClientInput;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_QUESTION = "시도할 회수는 몇 회 인가요?";

    public InputView() {
    }

    public ClientInput getClientInput() {
        ClientInput result;
        try(Scanner scanner = new Scanner(System.in))
        {
            System.out.println(CAR_QUESTION);
            int carCount = scanner.nextInt();
            System.out.println(TRY_QUESTION);
            int tryCount = scanner.nextInt();
            result = ClientInput.builder()
                    .carCount(carCount)
                    .tryCount(tryCount)
                    .build();
        }finally {
            scanner.close();
        }
        return result;
    }

}
