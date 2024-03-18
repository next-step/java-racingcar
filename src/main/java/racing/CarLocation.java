package racing;

import exception.CarLocationException;

public class CarLocation {
    private final Integer location;

    public CarLocation(Integer location) {
        try {
            validate(location);
        } catch (CarLocationException e) {
            throw new RuntimeException(e);
        }
        this.location = location;
    }

    public Integer getLocation() {
        return this.location;
    }

    public CarLocation moveForward() throws CarLocationException {
        Integer newLocation = this.location + 1;
        validate(newLocation);
        return new CarLocation(newLocation);
    }

    private void validate(Integer location) throws CarLocationException {
        if (location < 0) {
            throw new CarLocationException("음수로는 이동할 수 없습니다.");
        }
        if (location > Integer.MAX_VALUE) {
            throw new CarLocationException("최대 이동할 수 있는 범위를 넘을 수 없습니다.");
        }
    }
}
