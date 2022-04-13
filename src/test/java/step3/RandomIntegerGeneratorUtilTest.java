package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import step3.util.RandomIntegerGeneratorUtil;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("랜덤 숫자 생성기 테스트")
class RandomIntegerGeneratorUtilTest {

    @RepeatedTest(name = "{displayName}: {currentRepetition} / {totalRepetitions}", value = 1000)
    void _0과_9_사이의_랜덤한_정수를_생성한다() {
        assertThat(RandomIntegerGeneratorUtil.generate()).isBetween(0, 9);
    }

}