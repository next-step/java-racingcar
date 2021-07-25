package edu.nextstep.racingcar.step3.util;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

    @RepeatedTest(value = 100, name = "랜덤 넘버 생성 테스트 {currentRepetition} of {totalRepetitions}")
    void get_random_number() {
        RandomUtils randomUtils = new RandomUtils(10);
        Integer randomNumber = randomUtils.getRandomNumber();

        assertThat(randomNumber).isLessThanOrEqualTo(10);
    }
}