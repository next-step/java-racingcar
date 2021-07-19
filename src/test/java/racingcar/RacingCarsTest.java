package racingcar;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    private ArrayList<String> stringArrayList;

    @BeforeEach
    void setUp() {
        stringArrayList = new ArrayList<>();
    }

    @Test
    void 정적_팩토리_테스트() throws Exception {
        // given
        Class<RacingCars> expected = RacingCars.class;

        // when
        RacingCars actual = RacingCars.from(stringArrayList);

        // then
        Assertions.assertThat(actual).isNotNull().isInstanceOf(expected);
    }

    @Test
    void 조회_테스트() throws Exception {
        // given
        String expected = "-";
        stringArrayList.add(expected);

        // when
        String actual = RacingCars.from(stringArrayList).get(0);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 전진_테스트_조건은_참() throws Exception {
        // given
        String expected = "--";
        stringArrayList.add("-");

        // when
        RacingCars.from(stringArrayList).goForward(0, 4);
        String actual = RacingCars.from(stringArrayList).get(0);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 전진_테스트_조건은_거짓() throws Exception {
        // given
        String expected = "-";
        stringArrayList.add("-");

        // when
        RacingCars.from(stringArrayList).goForward(0, 3);
        String actual = RacingCars.from(stringArrayList).get(0);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 크기_조회_테스트() throws Exception {
        // given
        int expected = 3;
        stringArrayList.add("");
        stringArrayList.add("");
        stringArrayList.add("");

        // when
        int actual = RacingCars.from(stringArrayList).size();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}