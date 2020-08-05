package com.hskim.nextstep.step03.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/*
    com.hskim.nextstep.step03 - RandomUtils class 테스트
 */
public class RandomUtilsTest {

    /*
       랜덤값을 어떻게 테스트 할지..? 지정한 bound안에 드는 숫자가 나오는지를 검증을 한다고 할 때
       반복횟수를 늘려서 통과한다고 해도 100프로 신뢰할수 없는데..?
       https://stackoverflow.com/questions/14811014/writing-a-junit-test-for-a-random-number-generator
       https://multifrontgarden.tistory.com/187
     */
    private static final int ENOUGH_BIG_NUMBER = 10000;
    private static final int MOCK_BOUND = 30;

    @DisplayName("[0, bound) 사이의 랜덤한 Integer값을 반환하는 getRandomInteger() 메소드 테스트")
    @RepeatedTest(1000)
    void getRandomIntegerTest() {

        assertThat(RandomUtils.getRandomInteger(ENOUGH_BIG_NUMBER)).isBetween(0, ENOUGH_BIG_NUMBER-1);
    }

    @DisplayName("Mockito를 이용한 Random - nextInt() 메소드 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3,5,7,15,29})
    void getRandomIntegerMockTest(int value) {

        // given
        Random random = mock(Random.class);
        when(random.nextInt(MOCK_BOUND))
                .thenReturn(value);

        // when
        int result = random.nextInt(MOCK_BOUND);

        // then
        assertThat(result).isEqualTo(value);
    }

    /*
        RandomUtils(static 메소드)를 테스트하려면 power mock이 필요하다고 한다. 이건 다음에..
     */
}
