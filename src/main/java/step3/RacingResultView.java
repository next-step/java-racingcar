package step3;

public class RacingResultView implements ResultView {

    @Override
    public void print(Object o) {
        System.out.println(o.toString());
    }
}
