package ugemang.nextstep.domain.curcuit;

import ugemang.nextstep.domain.message.RacingGameMessageEnum;

public class Round {
    private final int round;

    public Round(int round) {
        validatePositiveRound(round);
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    private void validatePositiveRound(int round) {
        if(round < 0){
            throw new IllegalArgumentException(String.format(RacingGameMessageEnum.E1.getMessage(), round));
        }
    }
}
