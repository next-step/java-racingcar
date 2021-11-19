package step4.view;

import step4.common.MyException;
import step4.dto.count.TrialCount;

import java.util.InputMismatchException;
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
        RESULT_VIEW.println(RESULT_VIEW.ASK_CAR_NAME);

        return SCANNER.nextLine();
    }

    public TrialCount inputTrialCount() {
        RESULT_VIEW.println(RESULT_VIEW.ASK_TRIAL_COUNT);

        return new TrialCount(scannerInt());
    }

    private int scannerInt() {
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(MyException.NUMBER_IS_INTEGER.getMessage());
        }
    }
}
