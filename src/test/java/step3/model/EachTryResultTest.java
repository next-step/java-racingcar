package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("각 시도 결과 테스트")
class EachTryResultTest {

    @Test
    void 성공_횟수_리스트를_입력_받아서_1회_시도의_결과를_기록하는_객체를_생성한다() {
        List<Integer> moveCounts = Arrays.asList(1, 1, 1);

        EachTryResult eachTryResult = new EachTryResult(moveCounts);

        assertThat(eachTryResult.getMoveCounts()).isEqualTo(moveCounts);
    }

}