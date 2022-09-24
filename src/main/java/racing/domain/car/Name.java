package racing.domain.car;

import java.util.Objects;
import racing.domain.car.exception.FiveOverNameException;

public class Name {

    private final String name;

    public Name(String name) {
        validation(name);
        this.name = name;
    }

    private void validation(String name) {
        if (name.length() > 5) {
            throw new FiveOverNameException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
