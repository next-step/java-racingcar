package step1;

public abstract class FormulaNodeValue<T> implements FormulaNode<T> {
    protected final T value;

    protected FormulaNodeValue(final T value) {
        this.value = value;
    }

    public abstract int asInt();

    public abstract long asLong();

    public abstract T asType();

    @Override
    public String toString() {
        return String.valueOf(asLong());
    }
}
