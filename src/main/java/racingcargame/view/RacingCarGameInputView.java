package racingcargame.view;

import java.util.Scanner;

public class RacingCarGameInputView {
    static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputRoundNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        String name = inputCarNames();
        System.out.println(name);
    }
}
