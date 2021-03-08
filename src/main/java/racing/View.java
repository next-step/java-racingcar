package racing;

public abstract class View<T, U> {
    abstract public T show(U parameters);

    public final T show() {
        return show(null);
    }
}
