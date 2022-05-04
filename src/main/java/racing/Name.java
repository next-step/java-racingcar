package racing;

import java.util.Objects;

class Name {
    private String name;

    Name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 빈칸일 수는 없습니다.");
        }

        if (name.length() > 5) {
            throw new StringIndexOutOfBoundsException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }

        this.name = name;
    }

    String getName() {
        return this.name;
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
