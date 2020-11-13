package step5.domain.racing.cars;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-14.
 */
public class Name {

    private final String name;
    private final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private Name(String name) {
        checkEmpty(name);
        checkLength(name, MAXIMUM_CAR_NAME_LENGTH);

        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    public String name() {
        return this.name;
    }

    private static void checkEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()
                || "".equals(input) || " ".equals(input)) {
            throw new IllegalArgumentException("경주할 차 이름의 입력값이 없습니다.");
        }
    }

    private static void checkLength(String input, int length) {
        if (input.length() > length) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 %s 자를 초과할 수 없습니다.", length));
        }
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
}
