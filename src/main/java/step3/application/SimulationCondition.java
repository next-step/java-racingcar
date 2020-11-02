package step3.application;

import common.util.Message;
import step2.calculator.domain.Expression;

import static common.util.Preconditions.checkArgument;
import static step3.application.SimulationCondition.ErrorMessage.NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE;
import static step3.application.SimulationCondition.ErrorMessage.NUMBER_OF_CAR_MUST_MORE_THEN_ONE;

public class SimulationCondition {
    public enum ErrorMessage implements Message {
        NUMBER_OF_CAR_MUST_MORE_THEN_ONE(Expression.class.getName() + "'s numberOfCar must more then 1"),
        NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE(Expression.class.getName() + "'s numberOfAttempts must more then 1"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    private final int numberOfCar;
    private final int numberOfAttempts;

    public SimulationCondition(final int numberOfCar, final int numberOfAttempts) {
        checkArgument(numberOfCar >= 1, NUMBER_OF_CAR_MUST_MORE_THEN_ONE);
        checkArgument(numberOfAttempts >= 1, NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE);
        this.numberOfCar = numberOfCar;
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
