package racingcar.ui.view;

public interface InputView<V> {
    void take();

    void valid();

    V value();
}
