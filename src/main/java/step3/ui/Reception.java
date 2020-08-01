package step3.ui;

import step3.dto.ParticipationForm;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

import static step3.ui.MessageConstant.*;

public class Reception {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Reception() {}

    public static ParticipationForm takeParticipationForm() {
        Integer participationCount = retryUntilGettingRightValue(getParticipationCount());

        Integer attemptCount = retryUntilGettingRightValue(getAttemptCount());

        return new ParticipationForm(participationCount, attemptCount);
    }

    private static Integer retryUntilGettingRightValue(Supplier<Integer> supplier) {
        boolean retryFlag = true;
        Integer result = 0;
        while (retryFlag) {
            try {
                result = supplier.get();
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()+NEW_LINE);
            }
        }

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
