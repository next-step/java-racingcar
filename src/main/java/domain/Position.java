package domain;

public class Position implements Comparable<Position> {
    private int value;

    public Position(int value) {
        this.value = value;
        validate();
    }

    private void validate() {
        if (this.value < 0) {
            throw new IllegalArgumentException("Position value must be greater than or equal to 0.");
        }
    }

    public void increase() {
        this.value++;
    }

    @Override
    public String toString() {
        return "-".repeat(this.value);
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);

    private void validate() {
        if (this.value < 0) {
            throw new IllegalArgumentException("Position value must be greater than or equal to 0.");
        }
    }
}
