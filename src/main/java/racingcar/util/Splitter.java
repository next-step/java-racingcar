package racingcar.util;

import racingcar.constant.RacingMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Splitter {
    private static final String DELIMITER = ",";
    private static final int MAXIMUM_LENGTH = 5;
    private static final int MINIMUM_LENGTH = 1;

    private Splitter() {}

    public static List<String> splitText(String text) {
        List<String> texts = Arrays.stream(text.split(DELIMITER))
                .collect(Collectors.toList());
        validate(texts);
        return texts;
    }

    private static void validate(List<String> texts) {
        validateTextLength(texts);
        validateDuplicatedText(texts);
    }

    private static void validateTextLength(List<String> texts) {
        for (String text : texts) {
            if (text.length() < MINIMUM_LENGTH || text.length() > MAXIMUM_LENGTH) {
                throw new IllegalArgumentException(RacingMessage.VALID_NAME_LENGTH);
            }
        }
    }

    private static void validateDuplicatedText(List<String> texts) {
        Set<String> distinctTexts = new HashSet<>(texts);
        if (distinctTexts.size() != texts.size()) {
            throw new IllegalArgumentException(RacingMessage.DUPLICATED_NAME);
        }
    }
}
