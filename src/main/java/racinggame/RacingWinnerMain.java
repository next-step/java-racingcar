package racinggame;

import java.util.Scanner;

import static racinggame.view.InputView.*;

public class RacingWinnerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = readNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", scanner);
        int count = readCount("시도할 회수는 몇 회 인가요?", scanner);

        splitCarName(names);

        scanner.close();
    }

}
