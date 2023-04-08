public class PositiveInts {
    private final PositiveInt[] positiveInts;

    public PositiveInts(PositiveInt[] positiveInts) {
        this.positiveInts = positiveInts;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < positiveInts.length; i++) {
            sum += positiveInts[i].getValue();
        }
        return sum;
    }
}
