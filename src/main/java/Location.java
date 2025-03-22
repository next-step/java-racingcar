public class Location {
    private int value;

    public Location(int value) {
        this.value = value;
    }

    public void add(int offset) {
        this.value += offset;
    }

    public boolean isSame(int other) {
        return this.value == other;
    }

    public int max(int other) {
        return Math.max(this.value, other);
    }

    public int getValue() {
        return this.value;
    }
}
