package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.InputDTO;
import racingcar.model.entity.Car;
import racingcar.view.RacingCarUserInput;

public class ApplicationTest {

    private RacingCarUserInput userInput;
    private InputDTO inputDTO;

    @DisplayName("객체 초기화")
    @BeforeEach
    void init() {
        userInput = new RacingCarUserInput();
        inputDTO = new InputDTO(Arrays.asList("a", "aa", "aaa"), "CarNameIsLong", 10);
    }

    @DisplayName("유저_입력_글자길이_테스트")
    @Test
    void userInputLengthTest() {
        assertTrue(userInput.parsingCarName() == true);
    }

    @DisplayName("유저_입력_중복_테스트")
    @Test
    void userInputDuplicationTest() {
        assertThat(userInput.parsingCarName() == true);
    }

    @DisplayName("입력_횟수_범위_테스트")
    @Test
    void userInputRacingTryTest() {
        assertThat(userInput.parsingRacingTry() == true);
    }

    @DisplayName("우승자_확인_테스트")
    @Test
    public void maxCheckTest() {
        //given
        final List<Car> cars = Arrays.asList(Car.of("a"), Car.of("aa"), Car.of("aaa"));

        //when
        cars.get(0).moveForward();
        cars.get(0).moveForward();
        cars.get(0).moveForward();

        final int max = cars.stream().map(car -> car.getStep())
            .mapToInt(length -> Integer.valueOf(length))
            .max()
            .getAsInt();

        //then
        assertThat(cars.get(0).toString(max)).isEqualTo("a ");
    }
}
