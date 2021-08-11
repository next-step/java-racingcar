package racing_winner.domain;

import racing_winner.strategy.RacingStrategy;

public final class Racing {

    private Participants participants;
    private Round round;

    public Racing(final Participants participants, final Round round) {
        this.participants = participants;
        this.round = round;
    }
    public Racing(final String[] carNames, final int round) {
        this.participants = new Participants(carNames);
        this.round = new Round(round);
    }

    public RacingResult race(final RacingStrategy racingStrategy){
        if(roundFinish()) {
            throw new IllegalArgumentException("입력한 경기 이상의 경주는 불가능합니다");
        }
        round.race();
        return participants.race(racingStrategy);
    }

    public boolean roundFinish(){
        return round.isFinish();
    }
}
