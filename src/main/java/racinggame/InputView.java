package racinggame;

import java.util.Scanner;

public class InputView {

    private static final String CARNAME_DELIMETER = ",";

    public static RacingGameConfiguration getConfiguration() {

        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = sc.nextLine().split(CARNAME_DELIMETER);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTries = sc.nextInt();
        sc.nextLine();

        return new RacingGameConfiguration( carNames, numberOfTries );
    }

}