package stepone;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-14 00:15
 */

public class CharacterNormalizationTest {

    private CharacterNormalization normalization;

    @Test
    public void 공백제거() {
        normalization = new CharacterNormalization();
        assertThat(normalization.doCheckSpace("3 + 4 /2")).isEqualTo("3+4/2");
        assertThat(normalization.doCheckSpace("3 + 4 / 2")).isEqualTo("3+4/2");
    }

}
