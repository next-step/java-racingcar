package step4;

public class MaxLocation {
    private int maxLocation = 0;

    public void checkMax(Location location) {
        this.maxLocation = location.calculateMaxLocation(maxLocation);
    }

    public boolean isMaxLocation(Location location) {
        return location.getPosition() == this.maxLocation;
    }
}
