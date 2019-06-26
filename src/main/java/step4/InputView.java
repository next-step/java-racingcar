package step4;

import java.util.Scanner;

import static step4.ValidationCheck.*;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String playerNames = sc.nextLine();
        checkInputPlayerName(playerNames);
        String[] eachName = playerNames.split(",");
        checkInputSplitName(eachName);
        return eachName;
    }

    int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = sc.nextInt();
        checkInputTryCount(tryCount);
        return tryCount;
    }
}
