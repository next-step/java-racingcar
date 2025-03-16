package racing.fake;

import racing.service.NumberGenerator;

public class FakeNumberGenerator implements NumberGenerator {
    @Override
    public int generateRandomNumber(int num) {
        return num;
    }
}
