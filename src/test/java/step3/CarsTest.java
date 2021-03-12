package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class CarsTest {
    @ParameterizedTest(name = "생성자로 Map 변수 초기화 되었는지 테스트")
    @ValueSource(ints = {2, 3, 4, 5})
    void Cars(int participants) {
        // given
        Cars cars = new Cars(participants);
        int expected = participants;

        // when
        Map<Integer, String> actual = cars.getCars();

        // then
        Assertions.assertThat(actual).hasSize(expected);
    }

    @ParameterizedTest(name = "Cars 객체에서 Map 데이터 반환되는지 테스트")
    @ValueSource(ints = {2, 3, 4})
    void getCars(int howManyCars) {
        // given
        Map<Integer, String> expected = new HashMap<>();
        for (int i = 0; i < howManyCars; i++) {
            expected.put(i, "-");
        }

        // when
        Cars cars = new Cars(howManyCars);
        Map<Integer, String> actual = cars.getCars();

        // when
        for (int i = 0; i < howManyCars; i++) {
            Assertions.assertThat(actual.get(i)).isEqualTo(expected.get(i));
        }
    }

    @ParameterizedTest(name = "랜덤 숫자에 따라 전진여부 결정 테스트")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void moveDecision(int random) {
        // given
        int count = new Random().nextInt(9) + 1;
        Cars cars = new Cars(count);
        int randomIndex = new Random().nextInt(count);

        // when
        String actual = cars.getCars().get(randomIndex);
        actual = cars.moveDecision(random, actual);

        // then
        String expected = "-";
        if (random >= 4) {
            expected = expected + "-";
        }

        Assertions.assertThat(actual).isEqualTo(expected);
    }
    
}
