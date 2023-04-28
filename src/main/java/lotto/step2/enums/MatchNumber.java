package lotto.step2.enums;

import lotto.step2.domain.TotalReturn;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public enum MatchNumber {
    FOURTH(3, 5_000, "3개 일치 (5,000원)- "),
    THIRD(4, 50_000, "4개 일치 (50,000원)- "),
    SECOND(5, 1_500_000, "5개 일치 (1,500,000원)- "),
    FIRST(6, 200_000_000, "6개 일치 (2,000,000,000억)- ");

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

    public static Optional<MatchNumber> getMatchStat(int expectNumber) {
        return Arrays.stream(MatchNumber.values())
                .filter(e -> e.getMatchNumber() == expectNumber)
                .findFirst();
    }

    public static TotalReturn getTotalReturnResult(Map<Integer, Long> statMap, int cost) {
        long amount = statMap.entrySet().stream().map(entry -> (getMatchStat(entry.getKey())
                .map(match -> match.getMatchPrize() * entry.getValue()))
        ).flatMap(Optional::stream).mapToLong(Long::longValue).sum();

        double result = (double) amount / cost;
        return new TotalReturn(Math.floor(result * PERCENTAGE) / PERCENTAGE);
    }
}

