package racingcar.step4.service;

import racingcar.step4.domain.Names;
import racingcar.step4.domain.Round;
import racingcar.step4.domain.dto.RoundResultDto;
import racingcar.step4.domain.move.MoveStrategy;

import java.util.List;

public class RoundService {

    private final Round round;

    public RoundService(Names names, MoveStrategy moveStrategy) {
        this.round = new Round(moveStrategy, names);
    }

    public RoundResultDto startRound() {
        return round.move();
    }
}
