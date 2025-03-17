package racing.fake;

import racing.service.NumberGenerator;

public class FakeNumberGenerator implements NumberGenerator {
    private final int num;

    public FakeNumberGenerator(int num) {
        this.num = num;
    }

    @Override
    public int generateNumber() {
        return num;
    }
}
