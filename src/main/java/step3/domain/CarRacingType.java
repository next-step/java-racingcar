package step3.domain;

import step3.AbstractRacingCarGame;
import step3.UsingNameRacingCarGame;
import step3.strategy.move.MoveStrategy;
import step3.view.InputView;

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
