package racingcar.dto;


public final class RaceRequest {
    private static final String NAME_DELIMITER = ",";
    private static final String NOT_INTEGER_MESSAGE = "게임 횟수를 입력해 주세요.";
    private final String[] names;
    private final int totalRound;

    public RaceRequest(final String names, final String totalRound) {
        this.names = parseString(names);
        this.totalRound = parseInt(totalRound);
    }

    private static String[] parseString(final String names) {
        return names.split(NAME_DELIMITER);
    }

    private int parseInt(final String totalRound) {
        try {
            return Integer.parseInt(totalRound);
        } catch (final NumberFormatException numberFormatException) {
            throw new RuntimeException(NOT_INTEGER_MESSAGE);
        }
    }

    public String[] getNames() {
        return names;
    }

    public int getTotalRound() {
        return totalRound;
    }
}
