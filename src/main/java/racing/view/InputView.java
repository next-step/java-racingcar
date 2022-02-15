package racing.view;

import java.util.Scanner;
import racing.dto.RacingInfo;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private static String getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    private static int getTotalRoundNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(sc.nextLine());
    }

    public static RacingInfo getRacingInfo() {
        final String carNames = getCars();
        final int totalRoundNumber = getTotalRoundNumber();
        return new RacingInfo(carNames, totalRoundNumber);
    }
}
