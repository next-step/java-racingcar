package racing;

import exception.CarLocationException;

public class Location {
    private final Integer location;

    public Location(Integer location) {
        try {
            validate(location);
        } catch (CarLocationException e) {
            throw new RuntimeException(e);
        }
        this.location = location;
    }

    public Integer value() {
        return this.location;
    }

    public Location plusOne() throws CarLocationException {
        Integer newLocation = this.location + 1;
        validate(newLocation);
        return new Location(newLocation);
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
