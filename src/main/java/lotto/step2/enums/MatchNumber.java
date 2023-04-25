package lotto.step2.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum MatchNumber {
    FOURTH(3, 5000, "3개 일치 (5,000원)- "),
    THIRD(4, 50000, "4개 일치 (50,000원)- "),
    SECOND(5, 1500000, "5개 일치 (1,500,000원)- "),
    FIRST(6, 200000000, "6개 일치 (2,000,000,000억)- ");

    private final long matchNumber;
    private final int matchPrize;
    private final String matchText;
    private static final double PERCENTAGE = 100.0;

    MatchNumber(long matchNumber, int matchPrize, String matchText) {
        this.matchNumber = matchNumber;
        this.matchPrize = matchPrize;
        this.matchText = matchText;
    }

    public long getMatchNumber() {
        return matchNumber;
    }

    public int getMatchPrize() {
        return matchPrize;
    }

    public String getMatchText() {
        return matchText;
    }

    private static Optional<MatchNumber> getMatchStat(int expectNumber) {
        return Arrays.stream(MatchNumber.values())
                .filter(e -> e.getMatchNumber() == expectNumber)
                .findFirst();
    }

    public static List<String> getStatResult(Map<Integer, Long> statMap) {
        return statMap.entrySet().stream().map(entry -> {
            return getMatchStat(entry.getKey())
                    .map(match -> match.getMatchText() + entry.getValue() + "개");
        }).flatMap(Optional::stream).collect(Collectors.toList());
    }

    public static double getTotalReturnResult(Map<Integer, Long> statMap, int cost) {
        long amount = statMap.entrySet().stream().map(entry -> {
            return getMatchStat(entry.getKey())
                    .map(match -> match.getMatchPrize() * entry.getValue());
        }).flatMap(Optional::stream).mapToLong(Long::longValue).sum();

        double result = (double) amount / cost;
        return Math.floor(result * PERCENTAGE) / PERCENTAGE;
    }
}

