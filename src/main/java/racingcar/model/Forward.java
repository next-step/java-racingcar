package racingcar.model;

import racingcar.exception.ForwardNumberException;
import racingcar.model.enums.Status;
import racingcar.model.wrapper.ForwardNumber;

import java.util.Objects;

public class Forward {
    private final Status status;

    public Forward(ForwardNumber number) {
        this.status = Status.extractByNumber(number);
    }

    protected Forward(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forward forward = (Forward) o;
        return status == forward.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
