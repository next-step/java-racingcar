package study;

import java.util.Scanner;

public class InputView {

    private final String SPLIT_CHAR = ",";

    public RacingGame input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String tempCarName = scanner.nextLine();
        String[] carNames = tempCarName.split(SPLIT_CHAR);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();
        scanner.close();
        return new RacingGame(carNames, time);
    }



}
