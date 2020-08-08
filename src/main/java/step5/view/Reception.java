package step5.view;

import step5.dto.ParticipationForm;
import step5.view.input.InputChannel;
import step5.view.output.OutputChannel;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import static step5.constants.MessageConstant.*;

public class Reception {

    private static final Pattern WHITE_SPACE = Pattern.compile("\\s");
    private static final Pattern COMMA = Pattern.compile(",");
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String EMPTY_STRING = "";

    private final InputChannel inputChannel;
    private final OutputChannel outputChannel;

    public Reception(InputChannel inputChannel, OutputChannel outputChannel) {
        this.inputChannel = inputChannel;
        this.outputChannel = outputChannel;
    }

    public ParticipationForm takeParticipationForm() {
        String[] participationNames = retryUntilGettingRightValue(getParticipationNames());

        Integer attemptCount = retryUntilGettingRightValue(getAttemptCount());

        return new ParticipationForm(participationNames, attemptCount);
    }

    private <T> T retryUntilGettingRightValue(Supplier<T> supplier) {
        T result;
        do{
            result = getSupplierValue(supplier);
        } while (result == null);

        return result;
    }

    private <T> T getSupplierValue(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputChannel.printLine(e.getMessage()+NEW_LINE);
            return null;
        }
    }

    private Supplier<String[]> getParticipationNames() {
        return () -> sayQuestionAndGetDelimitedString(PLEASE_INPUT_PARTICIPATION_NAME);
    }

    private Supplier<Integer> getAttemptCount() {
        return () -> sayQuestionAndGetInt(HOW_MANY_ATTEMPT);
    }

    private String[] sayQuestionAndGetDelimitedString(String question) {
        outputChannel.printLine(question);
        String input = inputChannel.getStringValue();
        String[] split = splitParticipationNames(input);
        throwIfLengthOverFive(split);
        return split;
    }

    private int sayQuestionAndGetInt(String question) {
        outputChannel.printLine(question);
        return inputChannel.getIntValue();
    }

    private String[] splitParticipationNames(String participationNames) {
        String striped = WHITE_SPACE.matcher(participationNames).replaceAll(EMPTY_STRING);
        return COMMA.split(striped);
    }

    private void throwIfLengthOverFive(String[] split) {
        if(Arrays.stream(split).anyMatch(string -> string.length() > MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_SHOULD_UNDER_FIVE);
        }
    }
}
