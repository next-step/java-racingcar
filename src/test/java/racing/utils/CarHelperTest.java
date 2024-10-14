package racing.utils;

import com.racing.utils.CarHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarHelperTest {

    @Test
    @DisplayName("구분자(,)를 기준으로 String으로 분리")
    public void isEquals_SplitStringFromDelegate() {
        List<String> expectedValue = Arrays.asList("pobi", "crong", "honux");

        assertThat(CarHelper.splitCarName("pobi,crong,honux")).isEqualTo(expectedValue);
    }

}
