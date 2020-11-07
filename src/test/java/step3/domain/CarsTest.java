package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-11-07.
 */
class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(4);
        cars.getCars().get(0).forward(0);
        cars.getCars().get(1).forward(2);
        cars.getCars().get(2).forward(1);
        cars.getCars().get(3).forward(6);
    }

    @ParameterizedTest
    @DisplayName("랜덤 값에 따라 움직이는가")
    @CsvSource(value = {"2:false", "4:true", "8:true", "0:false"}, delimiter = ':')
    void runRound(int inputScore, boolean expected) {
        for (int i = 0; i < 4; i++) {
            // given
            int score = inputScore;

            // when
            int step = ScoreInspector.judgeMovable(score);
            boolean actual = step == 1 ? true : false;

            // then
            assertEquals(actual, expected);
        }
    }

    @Test
    @DisplayName("다른 경기장에 배정된 경주차그룹이 점수만 같을 때 경주차 그룹 중복인가")
    void isSame() {
        Cars a = new Cars(4);
        a.getCars().get(0).forward(0);
        a.getCars().get(1).forward(2);
        a.getCars().get(2).forward(1);
        a.getCars().get(3).forward(6);

        assertEquals(cars.equals(a), false);
    }

}