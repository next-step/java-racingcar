package step4.view;

import step4.dto.TrialCount;

import java.util.Scanner;

public class InputView {
    public static final InputView INSTANCE = new InputView();
    private static final ResultView RESULT_VIEW = ResultView.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String inputCarName() {
        RESULT_VIEW.sysout(RESULT_VIEW.ASK_CAR_NAME);

        return SCANNER.nextLine();
    }

    public TrialCount inputTrialCount() {
        RESULT_VIEW.sysout(RESULT_VIEW.ASK_TRIAL_COUNT);

        return new TrialCount(SCANNER.nextInt());
    }
}
