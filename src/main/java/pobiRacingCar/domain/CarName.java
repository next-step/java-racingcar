package pobiRacingCar.domain;

import pobiRacingCar.utils.StringUtils;

import java.util.Objects;

/**
 * 원시값 포장 : name 변수만 갖고 있어도 valid 등 가능
 */
public class CarName {
    public static final int NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        if (StringUtils.isNullOrBlank(name)) {
            throw new IllegalArgumentException("이름은 null값 빈값 안 됩니다");
        }
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        CarName carName = (CarName) o;
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
