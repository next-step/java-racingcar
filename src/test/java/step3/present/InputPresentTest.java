package step3.present;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class InputPresentTest {

    private InputPresent inputPresent;

    @AfterEach
    public void afterEach() {
        System.setIn(System.in);
    }

    private void setInputString(String inputString) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        this.inputPresent = new InputPresent();
    }

    @DisplayName("자동차 이름을 입력받을떄, 쉼표를 기준으로 구분한다")
    @Test
    public void commaSeaperate() {
        //given
        String input = "pobi,crong,honux";
        setInputString(input);
        //when
        List<Car> participates = inputPresent.participates();
        List<String> carNameList = participates.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        //then
        assertThat(String.join(",", carNameList)).isEqualTo(input);
    }
}