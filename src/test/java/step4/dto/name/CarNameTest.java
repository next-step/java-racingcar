package step4.dto.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.dto.count.Count;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", " , ", ", ", " ,", "a,", ",b", "a,,b"})
    @DisplayName("비어있는 자동차 이름을 인자로 받으면 예외를 던진다")
    public void nameNullTest(String name) {
        assertThatThrownBy(() -> {
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"kakao,toss,next|3", "rian,prodo|2", "dada|1", "안,녕,하,세,요|5"}, delimiter = '|')
    @DisplayName("1~5자인 자동차 이름을 인자로 받으면 정상적으로 자동차이름 그룹이 생성된다")
    public void createNameGroup(String names, int expected) {
        CarName carName = new CarName(names);

        assertThat(carName.carNameGroup().carNameLength()).isEqualTo(new Count(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"nextstep,next", "next,carRacing,step4", "step4,mission,hard,cry", "I,LOVE,REVIEWER,CATSBI", "help,me!!!!!!"})
    @DisplayName("1~5자가 아닌 자동차 이름을 인자로 받으면 예외를 던진다")
    public void createNameGroup(String names) {
        assertThatThrownBy(() -> {
            new CarName(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}