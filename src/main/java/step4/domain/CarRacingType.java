package step4.domain;

import step4.AbstractRacingCarGame;
import step4.UsingNameRacingCarGame;
import step4.strategy.move.MoveStrategy;
import step4.view.InputView;

public enum CarRacingType {

    USING_NAME_CAR("이름을 가지는 레이싱 게임") {
        @Override
        public AbstractRacingCarGame of(InputView inputView, MoveStrategy moveStrategy) {
            return new UsingNameRacingCarGame(inputView, moveStrategy);
        }
    };

    private final String desc;

    CarRacingType(String desc) {
        this.desc = desc;
    }

    public abstract AbstractRacingCarGame of(InputView inputView, MoveStrategy moveStrategy);

}
