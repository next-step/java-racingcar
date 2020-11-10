package racingcar.domain;

public interface WinStrategy {
    Winners decideWinners(RoundRecords roundRecords);
}
