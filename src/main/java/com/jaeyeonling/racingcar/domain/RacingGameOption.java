package com.jaeyeonling.racingcar.domain;

import java.util.Objects;

public class RacingGameOption {

    private final Participants participants;
    private final int movingCount;

    private RacingGameOption(final Builder builder) {
        participants = new Participants(builder.numberOfParticipants, builder.moveStrategy);
        movingCount = builder.movingCount;
    }

    public static Builder builder() {
        return new Builder();
    }

    Participants getParticipants() {
        return participants;
    }

    int getMovingCount() {
        return movingCount;
    }

    public static class Builder {
        private static final int DEFAULT_NUMBER_OF_PARTICIPANTS = 5;
        private static final int DEFAULT_MOVING_COUNT = 5;
        private static final MoveStrategy DEFAULT_MOVE_STRATEGY = new RandomMoveStrategy();

        private static final int MINIMUM_NUMBER_OF_PARTICIPANTS = 0;
        private static final int MAXIMUM_NUMBER_OF_PARTICIPANTS = 10_000;
        private static final int MINIMUM_MOVING_COUNT = 0;
        private static final int MAXIMUM_MOVING_COUNT = 10_000;

        private int numberOfParticipants = DEFAULT_NUMBER_OF_PARTICIPANTS;
        private int movingCount = DEFAULT_MOVING_COUNT;
        private MoveStrategy moveStrategy = DEFAULT_MOVE_STRATEGY;

        public Builder numberOfParticipants(final int numberOfParticipants) {
            checkNumberOfParticipantsConstraints(numberOfParticipants);

            this.numberOfParticipants = numberOfParticipants;
            return this;
        }

        public Builder movingCount(final int movingCount) {
            checkMovingCountConstraints(movingCount);

            this.movingCount = movingCount;
            return this;
        }

        public Builder moveStrategy(final MoveStrategy moveStrategy) {
            checkMovingStrategyConstraints(moveStrategy);

            this.moveStrategy = moveStrategy;
            return this;
        }

        public RacingGameOption build() {
            return new RacingGameOption(this);
        }

        private void checkNumberOfParticipantsConstraints(final int numberOfParticipants) {
            if (numberOfParticipants >= MAXIMUM_NUMBER_OF_PARTICIPANTS) {
                final String errorMessage = String.format("numberOfParticipants 값은 %d 이상이 될 수 없습니다. (입력 값: %d)",
                        MAXIMUM_NUMBER_OF_PARTICIPANTS,
                        numberOfParticipants);
                throw new IllegalArgumentException(errorMessage);
            }
            if (numberOfParticipants <= MINIMUM_NUMBER_OF_PARTICIPANTS) {
                final String errorMessage = String.format("numberOfParticipants 값은 %d 이하가 될 수 없습니다. (입력 값: %d)",
                        MINIMUM_NUMBER_OF_PARTICIPANTS,
                        numberOfParticipants);
                throw new IllegalArgumentException(errorMessage);
            }
        }

        private void checkMovingCountConstraints(final int movingCount) {
            if (movingCount >= MAXIMUM_MOVING_COUNT) {
                final String errorMessage = String.format("movingCount 값은 %d 이상이 될 수 없습니다. (입력 값: %d)",
                        MAXIMUM_MOVING_COUNT,
                        movingCount);
                throw new IllegalArgumentException(errorMessage);
            }
            if (movingCount <= MINIMUM_MOVING_COUNT) {
                final String errorMessage = String.format("movingCount 값은 %d 이하가 될 수 없습니다. (입력 값: %d)",
                        MINIMUM_MOVING_COUNT,
                        movingCount);
                throw new IllegalArgumentException(errorMessage);
            }
        }

        private void checkMovingStrategyConstraints(final MoveStrategy moveStrategy) {
            if (Objects.isNull(moveStrategy)) {
                throw new NullPointerException("MoveStrategy 는 null 일 수 없습니다.");
            }
        }
    }
}
