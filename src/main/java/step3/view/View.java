package step3.view;

public interface View<T> {
    T execute();
    default void execute(T t){
    }
}
