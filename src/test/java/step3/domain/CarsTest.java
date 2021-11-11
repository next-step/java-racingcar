package step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.service.IntNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 자동차_그룹을_생성한다() {
        //given
        String names = "java,c++,go";
        //when
        Cars cars = Cars.create(names);
        //then
        assertThat(cars).isNotNull();
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void 자동차_그룹에서_최대_위치를_조회한다() {
        //given
        String names = "java,c++,go";
        //when
        Cars cars = Cars.create(names);
        int maxPosition = cars.getMaxPosition();
        //then
        assertThat(maxPosition).isEqualTo(0);
    }

    @Test
    void 자동차가_3번_이동_하면_최대_위치는_3이다() {
        //given
        int round = 3;
        String names = "java,c++,go";
        //when
        Cars cars = Cars.create(names);
        while (round-- > 0) {
            cars.move(new IntNumberGenerator() {
                @Override
                public int generate() {
                    return 5;
                }
            });
        }
        int maxPosition = cars.getMaxPosition();
        //then
        assertThat(maxPosition).isEqualTo(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ",")
    void 경주에_참여할_자동차_수가_null_혹은_empty_면_IllegalArgumentException이_발생한다(String names) {
        //given
        //when & then
        assertThatThrownBy(() -> Cars.create(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
