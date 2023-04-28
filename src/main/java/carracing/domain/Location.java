package carracing.domain;

public class Location {
    private int location;

    public Location(int location) {
        if (location < 0) {
            throw new IllegalArgumentException("위치값은 음수일 수 없습니다.");
        }
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    void increase() {
        this.location++;
    }

    boolean isSame(int winnerLocation) {
        return winnerLocation == this.location;
    }
}
