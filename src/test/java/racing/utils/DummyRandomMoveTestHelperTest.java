package racing.utils;

import com.racing.utils.DummyRandomTestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DummyRandomMoveTestHelperTest {

    @Test
    @DisplayName("랜덤한 로직에 의해 false를 반환한다.")
    public void isEquals_GetRandomBoolean() {
        DummyRandomTestHelper testHelper = new DummyRandomTestHelper();

        assertThat(testHelper.shouldMove()).isEqualTo(false);
    }
}
