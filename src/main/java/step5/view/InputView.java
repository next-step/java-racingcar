package step5.view;

import step5.domain.RacingInformation;
import step5.domain.Separator;

import java.util.Scanner;

public class InputView {

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

    public static RacingInformation requestInput() {
        String carName = requestCarName();
        int numberOfReps = requestNumberOfTry();

        return RacingInformation.of(carName, numberOfReps);
    }

    public static String requestCarName() {
        showPrompt(REQUEST_CAR_NAME);
        return scanner.nextLine();
    }

    public static int requestNumberOfTry() {
        showPrompt(REQUEST_NUMBER_OF_TRY);
        return scanner.nextInt();
    }

    private static void showPrompt(String requestPrompt) {
        System.out.println(requestPrompt);
    }
}
