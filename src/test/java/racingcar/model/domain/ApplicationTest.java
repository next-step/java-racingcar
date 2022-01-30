package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.dto.InputDTO;
import racingcar.controller.dto.OutputDTO;
import racingcar.model.entity.Car;
import racingcar.model.utils.common.Validation;

public class ApplicationTest {

    private static final String COMMAS = ",";
    private InputDTO inputDTO;

    @DisplayName("객체 초기화")
    @BeforeEach
    void init() {
        inputDTO = new InputDTO(Arrays.asList("a", "aa", "aaa"), 10);
    }

    @DisplayName("유저_입력_글자길이_및_입력_중복_테스트")
    @Test
    void userInputLengthDuplicationTest() {
        String input = inputDTO.getSplitUserInput().stream().map(String::new).collect(Collectors.joining(","));
        assertFalse(Validation.parsingCarName(input));
    }

    @DisplayName("입력_횟수_범위_테스트")
    @Test
    void userInputRacingTryTest() {
        assertThat(Validation.parsingRacingTry(inputDTO.getRacingTryCounter()));
    }

    @DisplayName("우승자_확인_테스트")
    @ParameterizedTest
    @CsvSource({"a,aa,aaa"})
    public void maxCheckTest(String one, String two, String three) {
        //given
        final List<Car> cars = Arrays.asList(new Car(one), new Car(two), new Car(three));

        //when
        cars.get(0).moveForward();
        cars.get(0).moveForward();
        cars.get(0).moveForward();

        final int max = cars.stream().map(car -> car.getStep())
            .mapToInt(length -> Integer.valueOf(length))
            .max()
            .getAsInt();

        Victory victory = Victory.maxCheck(cars);
        List<OutputDTO> victoryResult = victory.victory()
            .stream()
            .map(OutputDTO::new)
            .collect(Collectors.toList());
        //then
        assertThat(victoryResult.stream().map(OutputDTO::getCarName)
            .collect(Collectors.joining(COMMAS))).isEqualTo("a");
    }

    @DisplayName("car클래스가 cars클래스에 Wrapping 검증")
    @ParameterizedTest
    @CsvSource({"a,aa,aaa"})
    void carWrappingTest(String one, String two, String three) {
        final List<Car> cars = Arrays.asList(new Car(one), new Car(two), new Car(three));
        Racing racing = new Racing(cars, RandomNumberBehavior.getInstance());
        List<Car> carsRepo = racing.getCars();
        assertAll(
            () -> assertThat(carsRepo.get(0).getName()).isEqualTo("a"),
            () -> assertThat(carsRepo.get(1).getName()).isEqualTo("aa"),
            () -> assertThat(carsRepo.get(2).getName()).isEqualTo("aaa")
        );
    }

    @DisplayName("랜덤넘버가 4이상일 때 전진할 수 있는지 검증")
    @ParameterizedTest
    @CsvSource({"a,aa,aaa"})
    void fixRandomNumberTest(String one, String two, String three) {
        final List<Car> cars = Arrays.asList(new Car(one), new Car(two), new Car(three));
        Racing racing = new Racing(cars, new FixNumberBehavior(true));
        racing.drive();
        racing.drive();
        assertAll(
            () -> assertThat(cars.get(0).getStep()).isEqualTo(2),
            () -> assertThat(cars.get(1).getStep()).isEqualTo(2),
            () -> assertThat(cars.get(2).getStep()).isEqualTo(2)
        );
    }

    @DisplayName("일급 컬렉션 테스트")
    @Test
    void name() {
        Cars cars = new Cars(inputDTO.getSplitUserInput());
        List<Car> carsTest = cars.cars();
        assertAll(
            () -> assertThat(carsTest.get(0).getName()).isEqualTo("a"),
            () -> assertThat(carsTest.get(1).getName()).isEqualTo("aa"),
            () -> assertThat(carsTest.get(2).getName()).isEqualTo("aaa")
        );
    }
}
