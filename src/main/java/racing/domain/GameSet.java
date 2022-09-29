package racing.domain;

import racing.rule.move.MoveStrategy;
import racing.rule.move.RandomMove;

import java.util.List;

import static util.NumberUtils.notPositive;

public class GameSet {
    private final static int POSITIVE_NUMBER_ONE = 1;
    private MoveStrategy moveStrategy;
    private List<String> carNames;
    private int numberOfMove;

    private GameSet(GameSetBuilder builder) {
        moveStrategy = builder.moveStrategy;
        carNames = builder.carNames;
        numberOfMove = builder.numberOfMove;
    }

    public static class GameSetBuilder {
        private final MoveStrategy moveStrategy;
        private final List<String> carNames;
        private final int numberOfMove;

        public GameSetBuilder(MoveStrategy moveStrategy, List<String> carNames, int numberOfMove) {
            validate(moveStrategy, carNames, numberOfMove);
            this.moveStrategy = moveStrategy;
            this.carNames = carNames;
            this.numberOfMove = numberOfMove;
        }

        public GameSet build() {
            return new GameSet(this);
        }

        public void validate(MoveStrategy moveStrategy, List<String> carNames, int numberOfMove) {
            if (moveStrategy == null) {
                throw new IllegalArgumentException("게임 규칙 설정이 잘못되었습니다.");
            }
            if (carNames.isEmpty() || carNames.size() < 2) {
                throw new IllegalArgumentException("차량 명칭 입력이 잘못되었습니다.");
            }
            if (notPositive(numberOfMove)) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
        }
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }
}