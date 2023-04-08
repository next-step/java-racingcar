package step2;

public class Conversion {

    private final String[] splits;

    public Conversion(String[] splits) {
        this.splits = splits;
    }

    public int[] stringToNumber() {
        return convertToIntArray();
    }

    private int[] convertToIntArray() {
        int[] ints = new int[this.splits.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(this.splits[i]);
        }
        return ints;
    }
}
