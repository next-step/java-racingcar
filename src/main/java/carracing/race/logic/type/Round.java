package carracing.race.logic.type;

public class Round implements Comparable<Round> {
    private final int value;
    public Round(int value) {
        this.value = value;
    }
    public int toInt() {
        return value;
    }
    @Override
    public int compareTo(Round other) {
        return Integer.compare(this.toInt(), other.toInt());
    }
}
