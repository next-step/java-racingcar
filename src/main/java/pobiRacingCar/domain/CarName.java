package pobiRacingCar.domain;

import pobiRacingCar.utils.StringUtils;
import pobiRacingCar.utils.ValidationUtils;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (StringUtils.isNullOrBlank(name)) {
            throw new IllegalArgumentException( "이름은 null값 빈값 안 됩니다 " );
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException( "이름은 5자 이하" );
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
