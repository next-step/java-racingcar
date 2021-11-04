package study02;

public class Operand {

    private final long operand;

    public Operand(String operand) {
        this(Long.parseLong(operand));
    }

    public Operand(long operand) {
        this.operand = operand;
    }

    public long getValue() {
        return this.operand;
    }

    public static boolean isValid(String operand) {
        try {
            Long.parseLong(operand);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Operand) {
            return this.operand == ((Operand) obj).operand;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.valueOf(this.operand);
    }
}
