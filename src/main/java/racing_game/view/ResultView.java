package racing_game.view;

public interface ResultView<T> {

    String resolve(T result);

    default void printResult(T result) {
        String view = resolve(result);
        System.out.println(view);
    }
}
