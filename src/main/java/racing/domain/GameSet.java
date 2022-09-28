package racing.domain;

import racing.rule.move.MoveStrategy;
import racing.rule.move.RandomMove;

import static util.NumberUtils.notPositive;

public class GameSet {
    private final static int POSITIVE_NUMBER_ONE = 1;
    private MoveStrategy moveStrategy;
    private int numberOfCars = 0;
    private int numberOfMove = 0;

    private GameSet(GameSetBuilder builder) {
        moveStrategy = builder.moveStrategy;
        numberOfCars = builder.numberOfCars;
        numberOfMove = builder.numberOfMove;
    }

    public static class GameSetBuilder {
        private final int numberOfCars;
        private final int numberOfMove;
        private final MoveStrategy moveStrategy;

        public GameSetBuilder() {
            this(1, 1, new RandomMove());
        }

        public GameSetBuilder(int numberOfCars) {
            this(numberOfCars, 1, new RandomMove());
        }

        public GameSetBuilder(int numberOfCars, int numberOfMove) {
            this(numberOfCars, numberOfMove, new RandomMove());
        }

        public GameSetBuilder(int numberOfCars, int numberOfMove, MoveStrategy moveStrategy) {
            validate(numberOfCars, numberOfMove, moveStrategy);
            this.numberOfCars = numberOfCars;
            this.numberOfMove = numberOfMove;
            this.moveStrategy = moveStrategy;
        }

        public GameSet build() {
            return new GameSet(this);
        }

        public void validate(int numberOfCars, int numberOfMove, MoveStrategy moveStrategy) {
            if (moveStrategy == null) {
                throw new IllegalArgumentException("게임 규칙 설정이 잘못되었습니다.");
            }
            if (notPositive(numberOfCars) || notPositive(numberOfMove)) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
        }
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }
}