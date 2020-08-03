package step3.ui;

import step3.dto.ParticipationForm;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.IntSupplier;

import static step3.constants.MessageConstant.*;

public class Reception {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int INIT = 0;

    private Reception() {}

    public static ParticipationForm takeParticipationForm() {
        int participationCount = retryUntilGettingRightValue(getParticipationCount());

        int attemptCount = retryUntilGettingRightValue(getAttemptCount());

        return new ParticipationForm(participationCount, attemptCount);
    }

    private static int retryUntilGettingRightValue(IntSupplier supplier) {
        boolean retryFlag = true;
        int result = INIT;
        while (retryFlag) {
            try {
                result = supplier.getAsInt();
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()+NEW_LINE);
            }
        }

        return result;
    }

    private static IntSupplier getParticipationCount() {
        return ()->sayQuestionAndGetAnswer(HOW_MANY_PARTICIPATION);
    }

    private static IntSupplier getAttemptCount() {
        return ()->sayQuestionAndGetAnswer(HOW_MANY_ATTEMPT);

    }

    private static int sayQuestionAndGetAnswer(String question) {
        System.out.println(question);
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(PLEASE_INPUT_INTEGER, e);
        } finally {
            SCANNER.nextLine();
        }
    }
}
