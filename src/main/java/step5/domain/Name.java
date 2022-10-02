package step5.domain;

import java.util.Objects;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name.trim();
    }


    private void validateName(String name) {
        if(isInvalidateName(name)){
            throw new IllegalStateException("자동차 이름은 " + MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "자여야 합니다.");
        }
    }

    private boolean isInvalidateName(String name) {
        return Objects.isNull(name) ||
                name.trim().length() < MIN_NAME_LENGTH ||
                name.trim().length() > MAX_NAME_LENGTH;
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
}
