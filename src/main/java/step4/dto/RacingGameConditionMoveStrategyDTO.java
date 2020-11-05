package step4.dto;

import step4.domain.MoveStrategy;

public class RacingGameConditionMoveStrategyDTO {
    private RacingGameConditionDTO racingGameConditionDTO;
    private MoveStrategy moveStrategy;


    private RacingGameConditionMoveStrategyDTO(RacingGameConditionDTO racingGameConditionDTO, MoveStrategy moveStrategy) {
        this.racingGameConditionDTO = racingGameConditionDTO;
        this.moveStrategy = moveStrategy;
    }

    public static RacingGameConditionMoveStrategyDTO of(RacingGameConditionDTO racingGameConditionDTO, MoveStrategy moveStrategy) {
        return new RacingGameConditionMoveStrategyDTO(racingGameConditionDTO, moveStrategy);
    }


    public RacingGameConditionDTO getRacingGameConditionDTO() {
        return racingGameConditionDTO;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
}
