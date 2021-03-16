package step5.domain;

public class FakeSuccessPolicy implements MovingPolicy{
    @Override
    public int generateRandom() {
        return 4;
    }
}
