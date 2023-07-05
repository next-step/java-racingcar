package racingcar;

public class ConsoleOutput implements Output {

    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
