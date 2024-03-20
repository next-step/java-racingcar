package step3.application.domain.model.vo;

import error.ErrorMessage;
import step3.application.domain.model.dto.MovementLog;

import java.util.Objects;

public class Driver {

    private final String name;

    public Driver(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_NAME.print());
        }
    }

    public MovementLog logNameAndPosition(int position) {
        return new MovementLog(this.name, position);
    }

    public boolean isSameAs(String name) {
        return Objects.equals(this.name, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
