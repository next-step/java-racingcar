package step5.client.worker.domain;

import common.util.Message;

import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step5.client.worker.domain.CarName.ErrorMessage.CAR_NAME_LENGTH_MUST_BELOW_THEN_FIVE;
import static step5.client.worker.domain.CarName.ErrorMessage.CAR_NAME_MUST_NOT_BE_BLANK;

public class CarName {
    public enum ErrorMessage implements Message {
        CAR_NAME_LENGTH_MUST_BELOW_THEN_FIVE("car name length must below then 5"),
        CAR_NAME_MUST_NOT_BE_BLANK("car name must not be blank"),
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

    private final String value;

    private CarName(final String value) {
        this.value = value;
    }

    public static CarName of(final String name) {
        checkArgument(Objects.nonNull(name) && !BLANK.equals(name), CAR_NAME_MUST_NOT_BE_BLANK);
        checkArgument(name.length() <= 5, CAR_NAME_LENGTH_MUST_BELOW_THEN_FIVE);
        return new CarName(name);
    }
    
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
