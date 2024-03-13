package racing;

import racing.enumable.InputAsk;

import java.util.Scanner;

public class Input {
    private static final String carNumberAsk = "자동차 대수는 몇 대 인가요?";
    private static final String attemptsNumberAsk = "시도할 횟수는 몇 회 인가요?";

    private final Scanner scanner;

    Input() {
        this.scanner = new Scanner(System.in);
    }

    public int askInput(InputAsk inputAsk) {
        showQuestion(inputAsk);
        return scanner.nextInt();
    }

    public static void showQuestion(InputAsk inputAsk) {
        if (inputAsk == InputAsk.CarNumber) {
            System.out.println(carNumberAsk);
        }

        if (inputAsk == InputAsk.Attempts) {
            System.out.println(attemptsNumberAsk);
        }
    }

    public void close() {
        this.scanner.close();
    }
}
