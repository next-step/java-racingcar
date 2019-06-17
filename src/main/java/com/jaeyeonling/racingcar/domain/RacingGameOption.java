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
        private static final MoveStrategy DEFAULT_MOVE_STRATEGY = new RacingStrategy();

        private static final int MINIMUM_NUMBER_OF_PARTICIPANTS = 0;
        private static final int MAXIMUM_NUMBER_OF_PARTICIPANTS = 10_000;
        private static final int MINIMUM_MOVING_COUNT = 0;
        private static final int MAXIMUM_MOVING_COUNT = 10_000;

        private int numberOfParticipants = DEFAULT_NUMBER_OF_PARTICIPANTS;
        private int movingCount = DEFAULT_MOVING_COUNT;
        private MoveStrategy moveStrategy = DEFAULT_MOVE_STRATEGY;

        public Builder numberOfParticipants(final int numberOfParticipants) {
            this.numberOfParticipants = numberOfParticipants;
            checkNumberOfParticipantsConstraints();

            return this;
        }

        public Builder movingCount(final int movingCount) {
            this.movingCount = movingCount;
            checkMovingCountConstraints();

            return this;
        }

        public Builder moveStrategy(final MoveStrategy moveStrategy) {
            this.moveStrategy = moveStrategy;
            checkMovingStrategyConstraints();

            return this;
        }

        public RacingGameOption build() {
            return new RacingGameOption(this);
        }

        private void checkNumberOfParticipantsConstraints() {
            if (numberOfParticipants >= MAXIMUM_NUMBER_OF_PARTICIPANTS) {
                throwConstraintsException(String.format("numberOfParticipants 값은 %d 이상이 될 수 없습니다. (입력 값: %d)",
                        MAXIMUM_NUMBER_OF_PARTICIPANTS,
                        numberOfParticipants));
            }
            if (numberOfParticipants <= MINIMUM_NUMBER_OF_PARTICIPANTS) {
                throwConstraintsException(String.format("numberOfParticipants 값은 %d 이하가 될 수 없습니다. (입력 값: %d)",
                        MINIMUM_NUMBER_OF_PARTICIPANTS,
                        numberOfParticipants));
            }
        }

        private void checkMovingCountConstraints() {
            if (movingCount >= MAXIMUM_MOVING_COUNT) {
                throwConstraintsException(String.format("movingCount 값은 %d 이상이 될 수 없습니다. (입력 값: %d)",
                        MAXIMUM_MOVING_COUNT,
                        movingCount));
            }
            if (movingCount <= MINIMUM_MOVING_COUNT) {
                throwConstraintsException(String.format("movingCount 값은 %d 이하가 될 수 없습니다. (입력 값: %d)",
                        MINIMUM_MOVING_COUNT,
                        movingCount));
            }
        }

        private void checkMovingStrategyConstraints() {
            if (Objects.isNull(moveStrategy)) {
                throwConstraintsException("MoveStrategy 는 null 일 수 없습니다.");
            }
        }

        private void throwConstraintsException(final String message) {
            throw new IllegalArgumentException(message);
        }
    }
}
