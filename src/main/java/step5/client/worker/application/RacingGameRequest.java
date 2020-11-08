package step5.client.worker.application;

import common.util.Message;
import step5.client.util.CarNamesSeparator;

import java.util.List;
import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step5.client.worker.application.RacingGameRequest.ErrorMessage.*;

public class RacingGameRequest {
    public enum ErrorMessage implements Message {
        NAME_OF_CAR_LENGTH_MUST_BELOW_THEN_FIVE("name of car's length must below then 5"),
        CAR_NAME_MUST_NOT_BE_DUPLICATED("car name must not be duplicated"),
        NAME_OF_CARS_MUST_NOT_BE_BLANK(RacingGameRequest.class.getName() + "'s carNames must not blank"),
        NUMBER_OF_CAR_MUST_MORE_THEN_ONE("number of car must more then 1"),
        NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE(RacingGameRequest.class.getName() + "'s numberAttempts must more then 1"),
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
    private final int numberAttempts;

    private RacingGameRequest(final List<String> carNames, final int numberAttempts) {
        this.carNames = carNames;
        this.numberAttempts = numberAttempts;
    }

    public static RacingGameRequest of(final String carNames, final String numberAttempts) {
        return new RacingGameRequest(createCarNames(carNames), createNumberAttempts(numberAttempts));
    }

    private static List<String> createCarNames(final String carNamesExpression) {
        checkArgument(Objects.nonNull(carNamesExpression) && !BLANK.equals(carNamesExpression), NAME_OF_CARS_MUST_NOT_BE_BLANK);
        
        final List<String> carNames = CarNamesSeparator.split(carNamesExpression);
        checkArgument(carNames.stream().noneMatch(carName -> carName.length() > 5), NAME_OF_CAR_LENGTH_MUST_BELOW_THEN_FIVE);
        checkArgument(carNames.stream().distinct().count() == carNames.size(), CAR_NAME_MUST_NOT_BE_DUPLICATED);
        checkArgument(carNames.size() >= 1, NUMBER_OF_CAR_MUST_MORE_THEN_ONE);
        return carNames;
    }

    private static int createNumberAttempts(final String numberAttemptsExpression) {
        final int numberAttempts = Integer.parseInt(numberAttemptsExpression);
        checkArgument(numberAttempts >= 1, NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE);
        return numberAttempts;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberAttempts() {
        return numberAttempts;
    }
}
