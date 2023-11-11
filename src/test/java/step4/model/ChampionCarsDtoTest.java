package step4.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChampionCarsDtoTest {

    @Test
    @DisplayName("우승 자동차 이름을 정상적으로 출력하는지 확인하는 테스트")
    void championToString() {
        // given
        ChampionCarsDto championCarsDto = new ChampionCarsDto(List.of(Car.makeCar("test1"), Car.makeCar("test2")));
        // when
        String result = championCarsDto.toString();
        // then
        Assertions.assertThat(result).isEqualTo("test1, test2가 최종 우승했습니다.");
    }
}