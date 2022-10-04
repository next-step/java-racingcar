package step3and4.client.output;

public class BarOutputView implements OutputView {

    private static final String BAR = "-";

    @Override
    public void print(int count) {
        System.out.println(BAR.repeat(count));
    }

}
