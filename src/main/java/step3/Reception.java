package step3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

public class Reception {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String HOW_MANY_PARTICIPATION = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_ATTEMPT = "시도할 회수는 몇 회 인가요?";
    private static final String PLEASE_INPUT_INTEGER = "잘못 입력 하셨습니다. 자연수로 입력 해 주세요.";

    private Reception() {}

    public static ParticipationForm takeParticipationForm() {
        Integer participationCount = retryUntilGettingRightValue(getParticipationCount());

        Integer attemptCount = retryUntilGettingRightValue(getAttemptCount());

        return new ParticipationForm(participationCount, attemptCount);
    }

    private static Integer retryUntilGettingRightValue(Supplier<Integer> supplier) {
        boolean retryFlag = true;
        Integer result = 0;
        do {
            try {
                result = supplier.get();
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()+"\n");
            }
        } while (retryFlag);

        return result;
    }

    private static Supplier<Integer> getParticipationCount() {
        return ()->sayQuestionAndGetAnswer(HOW_MANY_PARTICIPATION);
    }

    private static Supplier<Integer> getAttemptCount() {
        return ()->sayQuestionAndGetAnswer(HOW_MANY_ATTEMPT);

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
