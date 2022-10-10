package racingcar.winner.view;

public class ConsoleUserOutputInterface implements UserOutputInterface {
    @Override
    public void show(String message) {
        System.out.print(message);
    }
}
