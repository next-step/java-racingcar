package racingcar.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import racingcar.utils.ErrorMessage;
import racingcar.utils.StringUtils;

import java.util.Objects;

public class Name implements Comparable<Name>{

    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_NAME);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OVER_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Name o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
