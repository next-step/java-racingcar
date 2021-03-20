package step4.view;

import step4.vo.GameRequestVO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static GameRequestVO inputGameInfo() {
        return GameRequestVO.of(inputCarNames(), inputRoundCount());
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름으은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(",");
        return Arrays.asList(carNames);
    }

    private static int inputRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
