package racingGame.domain.game;

class Round {
    private int round;

    Round(int round) {
        verifyRound(round);
        this.round = round;
    }

    private void verifyRound(int round) {
        if (round < 0) {
            throw new IllegalArgumentException("라운드 수는 음수가 될 수 없습니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
