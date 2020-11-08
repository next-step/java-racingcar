package racingcar;

public interface WinStrategy {
    Winners decideWinners(RoundRecords roundRecords);
}
