package racingcar.domain.game.strategy;

public interface MoveStrategy {

    /**
     * 자동차가 움질일 수 있는 상태인지 반환한다.
     *
     * @return boolean
     */
    boolean movable();
}
