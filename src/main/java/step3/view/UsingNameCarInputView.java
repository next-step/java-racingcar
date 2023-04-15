package step3.view;

import step3.domain.Separator;
import step3.domain.UsingNameCarRacingInformation;

import java.util.Scanner;

public class UsingNameCarInputView implements InputView<UsingNameCarRacingInformation> {

    private final static Scanner scanner = new Scanner(System.in);
    private final static String REQUEST_CAR_NAME;
    private final static String REQUEST_NUMBER_OF_TRY = "시도할 회수는 몇 회 인가요?";

    static {
        StringBuilder stringBuilder = new StringBuilder();
        REQUEST_CAR_NAME = stringBuilder.append("경주할 자동차 이름을 입력하세요(이름은 ")
                .append(Separator.SPLIT_CAR_NAME_SEPARATOR.getDesc())
                .append("(")
                .append(Separator.SPLIT_CAR_NAME_SEPARATOR.getSeparator())
                .append(")")
                .append("기준으로 구분")
                .toString();

    }

    @Override
    public UsingNameCarRacingInformation execute() {
        String carName = requestCarName();
        int numberOfReps = requestNumberOfTry();

        return UsingNameCarRacingInformation.of(carName, numberOfReps);
    }

    private static class UsingNameCarInputViewInstanceHolder {
        private static final UsingNameCarInputView INSTANCE = new UsingNameCarInputView();
    }

    public static UsingNameCarInputView getInstance() {
        return UsingNameCarInputViewInstanceHolder.INSTANCE;
    }

    public String requestCarName() {
        showPrompt(REQUEST_CAR_NAME);
        return scanner.nextLine();
    }

    public int requestNumberOfTry() {
        showPrompt(REQUEST_NUMBER_OF_TRY);
        return scanner.nextInt();
    }

    private void showPrompt(String requestPrompt) {
        System.out.println(requestPrompt);
    }
}
