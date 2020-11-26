package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void create_input_view_instance() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @DisplayName("입력한 자동차 이름의 길이가 5자 초과 여부 테스트")
    @CsvSource(value = {"hyundai:true", "kia:false", "renault:true"} , delimiter = ':')
    void is_valid_car_name(String input, boolean expected) {
        assertThat(inputView.moreThanFiveWords(input.split(","))).isEqualTo(expected);
        assertThat(inputView.moreThanFiveWords(input.split(","))).isEqualTo(expected);
        assertThat(inputView.moreThanFiveWords(input.split(","))).isEqualTo(expected);
    }

}