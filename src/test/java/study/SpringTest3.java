package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-13 21:28
 */
public class SpringTest3 {

    /**
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     */
    @Test
    void charAt() {
//        String inputData = "abc";
//        assertThat(inputData.charAt(inputData.length())).

        assertThatThrownBy(() -> {
            String inputData = "abc";
            inputData.charAt(inputData.length());
            }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessage("[TEST] StringIndexOutOfBoundsException");
    }


    /* 강사님 조언 소스 */
    @Test
    void charAt2() {

//        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
//                .isThrownBy(() -> {
//                    String inputData = "abc";
//                    inputData.charAt(inputData.length());
//                }).

    }

}
