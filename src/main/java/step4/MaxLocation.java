package step4;

public class MaxLocation {
    private int maxLocation;

    public MaxLocation() {
        this(0);
    }

    public MaxLocation(int maxLocation) {
        this.maxLocation = maxLocation;
    }

    public void setMaxLocation(int location) {
        if (this.maxLocation < location) {
            this.maxLocation = location;
        }
    }

    public boolean isEqualToMaxLocation(int location) {
        return this.maxLocation == location;
    }
}
