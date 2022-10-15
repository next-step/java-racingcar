package racing.view;

import java.util.Scanner;

public class InputViewImpl implements InputView {

    private static final String ENTER_CAR_NAME_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ENTER_TRY_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String NAME_SEPARATOR = ",";
    private static final int LIMIT = -1;

    @Override
    public String[] enterCarName() {
        System.out.println(ENTER_CAR_NAME_TEXT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(NAME_SEPARATOR, LIMIT);
    }

    @Override
    public int enterTryCount() {
        System.out.println(ENTER_TRY_TEXT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
