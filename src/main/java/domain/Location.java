package domain;

public enum Location {
    ZERO(0),
    ONE(1);

    final int location;
    Location(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
