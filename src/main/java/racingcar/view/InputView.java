package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int getRacingCarNumbers() {
        System.out.println("******** 자동차 레이싱 게임 ********");
        System.out.println("참가하는 자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getRacingRound() {
        System.out.println("경기는 몇 ROUND 까지 진행하나요?");
        return scanner.nextInt();
    }
}
