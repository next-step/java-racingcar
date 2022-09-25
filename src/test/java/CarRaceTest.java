import domain.CarRace;
import org.junit.jupiter.api.Test;
import util.CommonUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {

    @Test
    public void 문자열_추가_확인() {
        StringBuilder line = new StringBuilder("");
        assertThat(CarRace.append(line)).contains("-");
    }

    @Test
    public void 랜덤_숫자_9이하인지_확인() {
        assertThat(CommonUtil.getRandomNumber()).isLessThanOrEqualTo(9);
    }

    @Test
    public void 랜덤_숫자_0이상인지_확인() {
        assertThat(CommonUtil.getRandomNumber()).isGreaterThanOrEqualTo(0);
    }

}
