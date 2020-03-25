package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.infrastructure.InMemoryRacingGameRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRepositoryTest {

    @DisplayName("저장소는 저장된 결과만큼 인트형을 반환한다.")
    @Test
    public void saveCountTest() {
        //given
        RacingGameRepository racingGameRepository = new InMemoryRacingGameRepository();
        List<Cars> cars = Arrays.asList(
                new Cars(Arrays.asList("정원", "자바", "레이서")),
                new Cars(Arrays.asList("정원", "자바", "레이서")),
                new Cars(Arrays.asList("정원", "자바", "레이서"))
        );

        //when
        int resultValue = racingGameRepository.saveAll(cars);

        //then
        assertThat(resultValue).isEqualTo(cars.size());
    }

}
