import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    @Test
    @DisplayName("랜던 이동 횟수 조회 테스트")
    void createRandomMoveCarsTest() {
        //given

        //when
        int randomInt = RandomUtil.getInt();

        //then
        Assertions.assertThat(randomInt).isBetween(0, 9);
    }
}
