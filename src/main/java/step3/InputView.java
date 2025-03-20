package step3;

import java.util.Scanner;

public class InputView {
    // InputView:
    // - 유저에게서 차 갯수를 입력 받는다.
    // - 유저에게서 게임 시도 횟수를 입력 받는다.
    // - 값을 입력 받는 API는 Scanner를 이용한다.
    private static final Scanner scanner = new Scanner(System.in);

    public int getCarCountFromUser() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getRoundCountFromUser() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
