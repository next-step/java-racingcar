package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumber;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RandomNumberTest {

    public static final int CAR_COUNT = 3;

    @DisplayName("랜덤 넘버 리스트 생성")
    @Test
    void generateNumbers() {
        //given
        RandomNumber randomNumber = new RandomNumber();

        //when
        List<Integer> list = randomNumber.generateNumbers(CAR_COUNT);

        //then
        assertThat(list.size()).isEqualTo(CAR_COUNT);
    }

}