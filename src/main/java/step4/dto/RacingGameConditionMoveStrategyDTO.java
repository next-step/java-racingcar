package step4.dto;

import step4.domain.MoveStrategy;

public class RacingGameConditionMoveStrategyDTO {
    private RacingGameConditionDTO racingGameConditionDTO;
    private MoveStrategy moveStrategy;

    public RacingGameConditionMoveStrategyDTO(RacingGameConditionDTO racingGameConditionDTO, MoveStrategy moveStrategy) {
        this.racingGameConditionDTO = racingGameConditionDTO;
        this.moveStrategy = moveStrategy;
    }

    public RacingGameConditionDTO getRacingGameConditionDTO() {
        return racingGameConditionDTO;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
}
