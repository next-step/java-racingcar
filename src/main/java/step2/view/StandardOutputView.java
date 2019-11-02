package step2.view;

public class StandardOutputView implements OutputView {
    @Override
    public void print(final String output) {
        System.out.println(output);
    }
}
