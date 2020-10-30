public class Operand {
    private final int num;

    public Operand(String str) {
        this.num = Integer.parseInt(str);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}