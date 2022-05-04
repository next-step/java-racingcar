package racing.domain;

import racing.util.RandomNumberGenerator;

public class RandomNumberProvider implements NumberProvider{
    @Override
    public int getNumber() {
        return RandomNumberGenerator.getRandomInt();
    }
}
