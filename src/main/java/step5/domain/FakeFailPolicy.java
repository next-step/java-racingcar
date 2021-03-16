package step5.domain;

public class FakeFailPolicy implements MovingPolicy {
    @Override
    public int generateRandom() {
        return 3;
    }
}
