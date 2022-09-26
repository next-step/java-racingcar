package racing.ui;

import java.util.Scanner;

public class InputViewImpl implements InputView {

    private static final String ENTER_CAR_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String ENTER_TRY_TEXT = "시도할 회수는 몇 회 인가요?";

    @Override
    public int enterCarCount() {
        System.out.println(ENTER_CAR_TEXT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public int enterTryCount() {
        System.out.println(ENTER_TRY_TEXT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
