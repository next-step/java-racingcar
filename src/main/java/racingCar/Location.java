package racingCar;

import java.util.Objects;

public class Location {

    private final static int MIN_LIMIT = 0;
    private int location;

    public Location(){
        this.location = MIN_LIMIT;
    }

    public Location(int location) {
        validLocation(location);
        this.location = location;
    }

    public void increase(){
        location++;
    }

    private void validLocation(int location) {
        if(location < MIN_LIMIT){
            throw new IllegalArgumentException("위치 값은 음수일 수 없습니다.");
        }
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
