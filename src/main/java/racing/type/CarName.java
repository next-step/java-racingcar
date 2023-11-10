package racing.type;

import java.util.Objects;

/**
 * 이름을 나타내는 타입
 * 불변 객체입니다.
 */
public class CarName {
    private String name;

    public CarName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name은 null일 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("name의 이름은 5자보다 길 수 없습니다.");
        }
        this.name = name;
    }

    /**
     * 익명 이름을 생성합니다.
     * @return 익명 이름
     */
    public static CarName anonymous() {
        return new CarName("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName name1 = (CarName) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
