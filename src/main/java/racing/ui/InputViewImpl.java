package racing.ui;

import java.util.Scanner;

public class InputViewImpl implements InputView {

    private static final String ENTER_CAR_NAME_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ENTER_TRY_TEXT = "시도할 회수는 몇 회 인가요?";

    @Override
    public String[] enterCarName() {
        System.out.println(ENTER_CAR_NAME_TEXT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(",");
    }

    @Override
    public int enterTryCount() {
        System.out.println(ENTER_TRY_TEXT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
