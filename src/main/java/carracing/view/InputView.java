package carracing.view;

import java.util.Scanner;

public class InputView {
    public static final String QUESTION_TRY_TIMES = "시도할 횟수는 몇회인가요?";
    public static final String QUESTION_CAR_COUNTS = "자동차 대수는 몇대인가요?";
    public static final String QUESTION_PARTICIPANTS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String DEMAND_6_UNDER_NAME_LENGTH = "자동차 이름은 1글자 이상 5글자 이하로 입력해주세요.";
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
        String[] names = participantsName().split(",");

        while (unfitableLength(names)){
            printDemand6UnderName();
            printQuestionParticipantsName();
            names = participantsName().split(",");
        }
        return names;
    }

    private boolean unfitableLength(String[] names) {
        for (String name : names) {
            if (name.length() > 6) {
                return true;
            }
        }
        return false;
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

    private void printDemand6UnderName() {
        System.out.println(DEMAND_6_UNDER_NAME_LENGTH);
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