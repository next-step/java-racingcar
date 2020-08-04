package com.hskim.nextstep.step03.utils;

import com.hskim.nextstep.step02.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
    com.hskim.nextstep.step03 - RandomUtils class 테스트
 */
public class RandomUtilsTest {

    /*
       랜덤값을 어떻게 테스트 할지..? 지정한 bound안에 드는 숫자가 나오는지를 검증을 한다고 할 때
       반복횟수를 늘려서 통과한다고 해도 100프로 신뢰할수 없는데..?
       https://stackoverflow.com/questions/14811014/writing-a-junit-test-for-a-random-number-generator
     */
    private static final int ENOUGH_BIG_NUMBER = 10000;

    @DisplayName("[0, bound) 사이의 랜덤한 Integer값을 반환하는 getRandomInteger() 메소드 테스트")
    @RepeatedTest(1000)
    void getRandomIntegerTest() {

        assertThat(RandomUtils.getRandomInteger(ENOUGH_BIG_NUMBER)).isBetween(0, ENOUGH_BIG_NUMBER-1);
    }
}
