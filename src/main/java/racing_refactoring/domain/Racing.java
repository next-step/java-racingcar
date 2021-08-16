package racing_refactoring.domain;

import racing_refactoring.strategy.RacingStrategy;

public class Racing {

    private Participants participants;
    private Round round;

    public Racing(final String[] carNames, final int trial) {
        this.participants = new Participants(carNames);
        this.round = new Round(trial);
    }

    public RacingResult race(final RacingStrategy racingStrategy){
        if(roundFinish()){
            throw new IllegalArgumentException("입력한 경기 이상의 경주는 불가능합니다");
        }
        round.next();
        return participants.race(racingStrategy);
    }

    public boolean roundFinish(){
        return round.isFinished();
    }
}
