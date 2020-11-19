package race.domain;

public interface ResultEmitter {
    void emitScores(LapScores lapScores);
    void emitWinner(LapScores lapScores);
}
