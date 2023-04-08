public class PositiveInt {
    private final int value;

    public PositiveInt(String str) {
        int anyNumber = Integer.parseInt(str);
        if (anyNumber < 0) {
            throw new RuntimeException();
        }
        this.value = anyNumber;
    }

    public int getValue() {
        return value;
    }
}
