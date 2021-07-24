package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @DisplayName("이름이 1글자~5글자 사이일 경우 객체생성")
    @ParameterizedTest
    @ValueSource(strings = {"바나나", "파인애플", "감", "천도복숭아"})
    void testCreateName(String input){
        assertThat(new Name(input)).isInstanceOf(Name.class);
    }

}