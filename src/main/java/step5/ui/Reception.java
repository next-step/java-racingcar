package step5.ui;

import step5.dto.ParticipationForm;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import static step3.constants.MessageConstant.PLEASE_INPUT_INTEGER;
import static step5.constants.MessageConstant.*;

public class Reception {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Pattern WHITE_SPACE = Pattern.compile("\\s");
    private static final Pattern COMMA = Pattern.compile(",");
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String EMPTY_STRING = "";

    private Reception() {}

    public static ParticipationForm takeParticipationForm() {
        String[] participationNames = retryUntilGettingRightValue(getParticipationNames());

        Integer attemptCount = retryUntilGettingRightValue(getAttemptCount());

        return new ParticipationForm(participationNames, attemptCount);
    }

    private static <T> T retryUntilGettingRightValue(Supplier<T> supplier) {
        boolean retryFlag = true;
        T result = null;

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

    private static Supplier<String[]> getParticipationNames() {
        return () -> sayQuestionAndGetDelimitedString(PLEASE_INPUT_PARTICIPATION_NAME);
    }

    private static Supplier<Integer> getAttemptCount() {
        return () -> sayQuestionAndGetInt(HOW_MANY_ATTEMPT);
    }

    private static String[] sayQuestionAndGetDelimitedString(String question) {
        System.out.println(question);
        try {
            String input = SCANNER.next();
            String[] split = splitParticipationNames(input);
            throwIfLengthOverFive(split);
            return split;
        } finally {
            SCANNER.nextLine();
        }
    }

    private static int sayQuestionAndGetInt(String question) {
        System.out.println(question);
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(PLEASE_INPUT_INTEGER, e);
        } finally {
            SCANNER.nextLine();
        }
    }

    private static String[] splitParticipationNames(String participationNames) {
        String striped = WHITE_SPACE.matcher(participationNames).replaceAll(EMPTY_STRING);
        return COMMA.split(striped);
    }

    private static void throwIfLengthOverFive(String[] split) {
        if(Arrays.stream(split).anyMatch(string -> string.length() > MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_IS_UNDER_FIVE);
        }
    }
}
