package step3and4.output;

public class BarOutputView implements OutputView {

    private static final String BAR = "-";

    @Override
    public void print(int count) {
        System.out.println(BAR.repeat(count));
    }

}
