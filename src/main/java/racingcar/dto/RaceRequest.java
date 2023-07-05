package racingcar.dto;


public class RaceRequest {
    private static final String NAME_DELIMITER = ",";
    private static final String NOT_INTEGER_MESSAGE = "게임 횟수를 입력해 주세요.";
    private final String[] names;
    private final int totalRound;

    public RaceRequest(String names, String totalRound) {
        this.names = parseString(names);
        this.totalRound = parseInt(totalRound);
    }

    private static String[] parseString(String names) {
        return names.split(NAME_DELIMITER);
    }

    private int parseInt(String totalRound) {
        try {
            return Integer.parseInt(totalRound);
        } catch (NumberFormatException numberFormatException) {
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
