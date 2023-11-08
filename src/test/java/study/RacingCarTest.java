package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.car.CarServiceImpl;
import study.car.MemoryCarRepository;
import study.racing.RacingCarPolicy;
import study.utils.RandomUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    MemoryCarRepository memoryCarRepository;
    CarServiceImpl carService;

    @BeforeEach
    public void beforeEach() {
        memoryCarRepository = new MemoryCarRepository();
        carService = new CarServiceImpl(memoryCarRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryCarRepository.clearStore();
    }

    @ParameterizedTest
    @ValueSource(strings = "1")
    @DisplayName("scanner 동작 테스트")
    void scannerTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();

        assertThat(inputValue).isEqualTo("1");
    }

    @Test
    @DisplayName("0-9 사이의 랜덤 숫자를 생성한다.")
    void getRandom0To9NumberTest() {
        int randomNumber = RandomUtils.getRandomNumberZeroToNine();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3"})
    @DisplayName("0-3의 숫자인 경우 false를 반환한다.")
    void stopCarTest(int input) {
        boolean result = RacingCarPolicy.canMovingCar(input);
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6", "7", "8", "9"})
    @DisplayName("4-9의 숫자인 경우 true를 반환한다.")
    void goCarTest(int input) {
        boolean result = RacingCarPolicy.canMovingCar(input);
        assertThat(result).isTrue();
    }

    @Test
    void setRacingCarTest() {
        //given
        RacingCar racingCar = new RacingCar(3, 3, memoryCarRepository);

        //when
        racingCar.startRacing();

    }

}
