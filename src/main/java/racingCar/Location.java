package racingCar;

public class Location {

    private final static int MIN_LIMIT = 0;
    private int location;

    public Location(int location) {
        validLocation(location);
        this.location = location;
    }

    private void validLocation(int location) {
        if(location < MIN_LIMIT){
            throw new IllegalArgumentException("위치 값은 음수일 수 없습니다.");
        }
    }

    public int getLocation() {
        return location;
    }
}
