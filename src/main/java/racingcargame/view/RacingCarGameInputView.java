package racingcargame.view;

import java.util.Scanner;

public class RacingCarGameInputView {
<<<<<<< HEAD
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
=======
    private final Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
>>>>>>> origin/step2
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputRoundNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int roundNumber = scanner.nextInt();
        checkRoundNumber(roundNumber);
        return roundNumber;
    }

    private void checkRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new IllegalArgumentException("게임을 시도할 횟수는 0 이상이어야 한다.");
        }
    }
}
