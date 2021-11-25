package step3;

import java.io.Closeable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView implements Closeable {
    private static final InputView INSTANCE = new InputView();
    private static final ResultView RESULT_VIEW = ResultView.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String QUESTION_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_TRIAL_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputView() { }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public Count registerCar() {
        RESULT_VIEW.println(QUESTION_CAR_MESSAGE);

        return inputValue();
    }

    public Count registerTrialCount() {
        RESULT_VIEW.println(QUESTION_TRIAL_COUNT_MESSAGE);

        return inputValue();
    }

    public Count inputValue() {
        try {
            int input = SCANNER.nextInt();

            return new Count(input);

        } catch(InputMismatchException e) {
            throw new InputMismatchException(MyException.IS_NOT_NUMBER.getMessage());
        }
    }

    @Override
    public void close() {
        SCANNER.close();
    }
}
