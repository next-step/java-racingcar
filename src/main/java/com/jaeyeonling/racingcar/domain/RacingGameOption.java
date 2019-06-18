package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.exception.*;
import com.jaeyeonling.racingcar.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RacingGameOption {

    public static final String NAME_SEPARATOR = ",";

    private final Participants participants;
    private final int movingCount;

    private RacingGameOption(final Builder builder) {
        participants = new Participants(builder.nameOfParticipants, builder.moveStrategy);
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
        private static final int DEFAULT_MOVING_COUNT = 5;
        private static final MoveStrategy DEFAULT_MOVE_STRATEGY = new RacingStrategy();

        private List<String> nameOfParticipants;
        private int movingCount = DEFAULT_MOVING_COUNT;
        private MoveStrategy moveStrategy = DEFAULT_MOVE_STRATEGY;

        public Builder nameOfParticipants(final String nameOfParticipants) {
            if (StringUtils.isEmpty(nameOfParticipants)) {
                throwNameOfParticipantsEmpty();
            }

            this.nameOfParticipants = Arrays.asList(nameOfParticipants.split(NAME_SEPARATOR));
            checkNameOfParticipantsConstraints();

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
            checkNameOfParticipantsConstraints();

            return new RacingGameOption(this);
        }

        private void checkNameOfParticipantsConstraints() {
            if (Objects.isNull(nameOfParticipants)) {
                throwNameOfParticipantsEmpty();
            }
            if (nameOfParticipants.size() >= ParticipantsLongerThanMaxException.MAXIMUM_NUMBER_OF_PARTICIPANTS) {
                throw new ParticipantsLongerThanMaxException(nameOfParticipants.size());
            }
            if (nameOfParticipants.size() <= ParticipantsShorterThanMinException.MINIMUM_NUMBER_OF_PARTICIPANTS) {
                throw new ParticipantsLongerThanMaxException(nameOfParticipants.size());
            }
        }

        private void checkMovingCountConstraints() {
            if (movingCount >= MovingCountLongerThanMaxException.MAXIMUM_MOVING_COUNT) {
                throw new MovingCountLongerThanMaxException(movingCount);
            }
            if (movingCount <= MovingCountShorterThanMinException.MINIMUM_MOVING_COUNT) {
                throw new MovingCountShorterThanMinException(movingCount);
            }
        }

        private void checkMovingStrategyConstraints() {
            if (Objects.isNull(moveStrategy)) {
                throw new InvalidMoveStrategyException();
            }
        }

        private void throwNameOfParticipantsEmpty() {
            throw new InvalidNameOfParticipantsException();
        }
    }
}
