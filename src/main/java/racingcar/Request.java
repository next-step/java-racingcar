package racingcar;


public class Request {
    private final String[] names;
    private final int totalRound;

    public Request(String names, String totalRound) {
        this.names = Parser.parse(names);
        try {
            this.totalRound = Integer.parseInt(totalRound);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("게임 횟수를 입력해 주세요.");
        }
        validateRound(this.totalRound);
    }

    private static void validateRound(int totalRound) {
        if (totalRound <= 0) {
            throw new RuntimeException("게임 횟수는 0 이상이어야 합니다.");
        }
    }

    public String[] getNames() {
        return names;
    }

    public int getTotalRound() {
        return totalRound;
    }
}
