package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reception {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String HOW_MANY_PARTICIPATION = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_ATTEMPT = "시도할 회수는 몇 회 인가요?";
    private static final String PLEASE_INPUT_INTEGER = "잘못 입력 하셨습니다. 소숫점이 없는 숫자로 입력해주세요.";

    public static void takeParticipationForm() {
        Integer participationCount;
        try {
            participationCount = getParticipationCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()+"\n");
            participationCount = getParticipationCount();
        }
        Integer attemptCount;
        try {
            attemptCount = getAttemptCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()+"\n");
            attemptCount = getAttemptCount();
        }


        System.out.println(" 대수 : '" +participationCount + "' 시도 횟수 : '" + attemptCount + "'");

    }

    private static Integer getParticipationCount() {
        return sayQuestionAndGetAnswer(HOW_MANY_PARTICIPATION);
    }

    private static Integer getAttemptCount() {
        return sayQuestionAndGetAnswer(HOW_MANY_ATTEMPT);

    }

    private static Integer sayQuestionAndGetAnswer(String question) {
        System.out.println(question);
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(PLEASE_INPUT_INTEGER);
        } finally {
            SCANNER.nextLine();
        }
    }
}
