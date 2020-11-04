package step3.application;

import common.util.Message;
import step3.util.CarNamesSeparator;

import java.util.List;
import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step3.application.SimulationCondition.ErrorMessage.*;

public class SimulationCondition {
    public enum ErrorMessage implements Message {
        NAME_OF_CAR_LENGTH_MUST_BELOW_THEN_FIVE("name of car's length must below then 5"),
        NAME_OF_CARS_MUST_NOT_BE_BLANK(SimulationCondition.class.getName() + "'s carNames must not blank"),
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

    private final List<String> carNames;
    private final int numberOfAttempts;

    private SimulationCondition(final List<String> carNames, final int numberOfAttempts) {
        this.carNames = carNames;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static SimulationCondition of(final String nameOfCars, final String numberOfAttempts) {
        return new SimulationCondition(createCarNames(nameOfCars), createNumberOfAttempts(numberOfAttempts));
    }

    private static List<String> createCarNames(final String nameOfCars) {
        checkArgument(Objects.nonNull(nameOfCars) && !BLANK.equals(nameOfCars), NAME_OF_CARS_MUST_NOT_BE_BLANK);
        
        final List<String> carNames = CarNamesSeparator.split(nameOfCars);
        checkArgument(carNames.stream().noneMatch(carName -> carName.length() > 5), NAME_OF_CAR_LENGTH_MUST_BELOW_THEN_FIVE);
        checkArgument(carNames.size() >= 1, NUMBER_OF_CAR_MUST_MORE_THEN_ONE);
        return carNames;
    }

    private static int createNumberOfAttempts(final String numberOfAttempts) {
        final int numberAttempts = Integer.parseInt(numberOfAttempts);
        checkArgument(numberAttempts >= 1, NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE);
        return numberAttempts;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
