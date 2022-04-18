package step3.view.dto;

import step3.model.EachTryResult;

import java.util.Map;
import java.util.stream.Collectors;

public class EachTryResultDto {

    private static final String DISPLAY_CHARACTER = ">";
    private static final String LINE_BREAK_PER_CAR = "\n";

    private final String eachTryResult;

    public EachTryResultDto(EachTryResult eachTryResult) {
        this.eachTryResult = initEachTryResult(eachTryResult.getMoveCountEach());
    }

    private String initEachTryResult(Map<String, Integer> moveCountEach) {
        return moveCountEach.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(this::parseEntry)
                .collect(Collectors.joining(LINE_BREAK_PER_CAR));
    }

    private String parseEntry(Map.Entry<String, Integer> entry) {
        return entry.getKey() + ": " + toCharacter(entry.getValue());
    }

    private String toCharacter(Integer value) {
        return DISPLAY_CHARACTER.repeat(value);
    }

    @Override
    public String toString() {
        return eachTryResult;
    }
}
