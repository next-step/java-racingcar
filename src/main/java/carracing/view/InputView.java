package carracing.view;

import java.util.Scanner;

public class InputView {
    public static final String QUESTION_TRY_TIMES = "시도할 횟수는 몇회인가요?";
    public static final String QUESTION_CAR_COUNTS = "자동차 대수는 몇대인가요?";
    public static final String QUESTION_PARTICIPANTS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    Scanner scanner = new Scanner(System.in);

    public int scanTimes() {
        printQuestionTryTimes();
        return tryTimes();
    }

    public int scanCounts() {
        printQuestionCarCount();
        return carCounts();
    }

    public String[] scanParticipantsName() {
        printQuestionParticipantsName();
        return participantsName().split(",");
    }

    private void printQuestionParticipantsName() {
        System.out.println(QUESTION_PARTICIPANTS_NAME);
    }

    private void printQuestionCarCount() {
        System.out.println(QUESTION_CAR_COUNTS);
    }

    private void printQuestionTryTimes() {
        System.out.println(QUESTION_TRY_TIMES);
    }

    private int carCounts() {
        return scanner.nextInt();
    }

    private int tryTimes() {
        return scanner.nextInt();
    }

    private String participantsName() {
        return scanner.next();
    }
}
