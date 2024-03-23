package racing.domain.vo;

import java.util.Objects;

public class Name {
    private final String text;

    public Name(final String name) {
        validateNameNotBlank(name);
        this.text = name;
    }

    private void validateNameNotBlank(final String name){
        if(name.isBlank())
            throw new IllegalArgumentException("이름은 비어있거나 없으면 안됩니다.");
    }

    public String getName() {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(text, name.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
