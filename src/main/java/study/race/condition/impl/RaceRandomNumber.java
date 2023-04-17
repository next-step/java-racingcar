package study.race.condition.impl;

import study.race.condition.RaceConditionNumber;
import study.util.RandomNumberUtil;

public class RaceRandomNumber implements RaceConditionNumber {

    @Override
    public int fetch() {
        return RandomNumberUtil.getRandomNumber();
    }
    
}
