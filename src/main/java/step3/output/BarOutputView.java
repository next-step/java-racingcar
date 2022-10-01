package step3.output;

public class BarOutputView implements OutputView {

    private static final String BAR = "-";

    @Override
    public void print(int count) {
        System.out.println(BAR.repeat(count));
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return isBarOutputView(obj);
    }

    private boolean isBarOutputView(Object object) {
        return object instanceof BarOutputView;
    }

}
