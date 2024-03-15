package racing;

import racing.enumable.InputAsk;

import java.util.Scanner;

public class Input {
    private static final String carNumberAsk = "자동차 대수는 몇 대 인가요?";
    private static final String attemptsNumberAsk = "시도할 횟수는 몇 회 인가요?";
    private static final String carNameAsk = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final Scanner scanner;

    Input() {
        this.scanner = new Scanner(System.in);
    }

    public int askIntInput(InputAsk inputAsk) {
        showQuestion(inputAsk);
        return scanner.nextInt();
    }

    public String askStringInput(InputAsk inputAsk) {
        showQuestion(inputAsk);
        return scanner.nextLine();
    }

    public static void showQuestion(InputAsk inputAsk) {
        if (inputAsk == InputAsk.CarNumber) {
            System.out.println(carNumberAsk);
        }

        if (inputAsk == InputAsk.Attempts) {
            System.out.println(attemptsNumberAsk);
        }

        if (inputAsk == InputAsk.CarName) {
            System.out.println(carNameAsk);
        }
    }

    public void close() {
        this.scanner.close();
    }
}
