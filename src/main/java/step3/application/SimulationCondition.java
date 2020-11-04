package step3.application;

import common.util.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step3.application.SimulationCondition.ErrorMessage.*;

public class SimulationCondition {
    public enum ErrorMessage implements Message {
        NAME_OF_CARS_MUST_NOT_BE_BLANK(SimulationCondition.class.getName() + "'s nameOfCars must not blank"),
        NUMBER_OF_CAR_MUST_MORE_THEN_ONE("number of car must more then 1"),
        NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE(SimulationCondition.class.getName() + "'s numberOfAttempts must more then 1"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    private static final String BLANK = "";

    private final List<String> nameOfCars;
    private final int numberOfAttempts;

    private SimulationCondition(final List<String> nameOfCars, final int numberOfAttempts) {
        this.nameOfCars = nameOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static SimulationCondition of(final String nameOfCars, final String numberOfAttemptsString) {
        checkArgument(Objects.nonNull(nameOfCars) && !BLANK.equals(nameOfCars), NAME_OF_CARS_MUST_NOT_BE_BLANK);

        final List<String> nameOfCarList = Arrays.asList(nameOfCars.split(","));
        final int numberOfAttempts = Integer.parseInt(numberOfAttemptsString);

        checkArgument(nameOfCarList.size() >= 1, NUMBER_OF_CAR_MUST_MORE_THEN_ONE);
        checkArgument(numberOfAttempts >= 1, NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE);
        return new SimulationCondition(nameOfCarList, numberOfAttempts);
    }

    public List<String> getNameOfCars() {
        return nameOfCars;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
