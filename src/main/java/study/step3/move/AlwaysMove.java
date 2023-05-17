package study.step3.move;

public class AlwaysMove implements Move {
    @Override
    public boolean isSuccess() {
        return true;
    }
}
