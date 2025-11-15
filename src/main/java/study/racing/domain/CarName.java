package study.racing.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        validateIsBlank(name);
        this.name = name;
    }

    private void validateIsBlank(String name) {
        if(isBlank(name)){
            throw new RuntimeException("차량 이름은 필수입니다.");
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    public String value() {
        return this.name;
    }

    private static void validateNameLength(String name) {
        if (isNameLength(name)) {
            throw new RuntimeException("차량 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static boolean isNameLength(String name) {
        return name.length() > 5;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
