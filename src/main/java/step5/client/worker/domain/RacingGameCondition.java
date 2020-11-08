package step5.client.worker.domain;

import common.util.Message;
import step5.client.util.CarNamesSeparator;

import java.util.List;
import java.util.stream.Collectors;

import static common.util.Preconditions.checkArgument;
import static step5.client.worker.domain.RacingGameCondition.ErrorMessage.*;

public class RacingGameCondition {
    public enum ErrorMessage implements Message {
        CAR_NAME_MUST_NOT_BE_DUPLICATED("car name must not be duplicated"),
        NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE(RacingGameCondition.class.getName() + "'s numberAttempts must more then 1"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    private final List<CarName> carNames;
    private final int numberAttempts;

    private RacingGameCondition(final List<CarName> carNames, final int numberAttempts) {
        this.carNames = carNames;
        this.numberAttempts = numberAttempts;
    }

    public static RacingGameCondition of(final String carNames, final String numberAttempts) {
        return new RacingGameCondition(createCarNames(carNames), createNumberAttempts(numberAttempts));
    }

    private static List<CarName> createCarNames(final String carNamesExpression) {
        final List<String> carNames = CarNamesSeparator.split(carNamesExpression);
        checkArgument(carNames.stream().distinct().count() == carNames.size(), CAR_NAME_MUST_NOT_BE_DUPLICATED);
        return carNames.stream()
                .map(CarName::of)
                .collect(Collectors.toList());
    }

    private static int createNumberAttempts(final String numberAttemptsExpression) {
        final int numberAttempts = Integer.parseInt(numberAttemptsExpression);
        checkArgument(numberAttempts >= 1, NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE);
        return numberAttempts;
    }

    public List<CarName> getCarNames() {
        return carNames;
    }

    public int getNumberAttempts() {
        return numberAttempts;
    }
}
