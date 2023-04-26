package basicgame.service.strategy;

import util.RandomUtil;

public class RandomActive implements ActiveStrategy{

    @Override
    public int generateRandom(int max) {
        return RandomUtil.getRandomValue(max);
    }
}
