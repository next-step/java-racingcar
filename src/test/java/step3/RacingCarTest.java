package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.car.Car;
import step3.car.RacingCar;
import step3.factory.RacingCarFactory;
import step3.game.RacingGame;
import step3.game.RacingGameImpl;
import step3.game.RacingInfomation;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("RacingGame 테스")
public class RacingCarTest {
    private RacingGame racingGame;
    private ResultView resultView;
    private RacingCarFactory racingCarFactory;

    @BeforeEach
    void setup() {
        racingGame = new RacingGameImpl();
        resultView = ResultView.getInstance();
        racingCarFactory = RacingCarFactory.getFactory();
    }

    @DisplayName("자동차의 이동조건에 따른 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true", "6:true", "7:true", "8:true", "9:true"},
            delimiter = ':')
    public void allowMoveTest(Integer input, boolean result) {
        Car car = racingCarFactory.createCar();
        assertThat(car.allowMove(input)).isEqualTo(result);
    }

    @DisplayName("자동차의 경주결과 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3:1,5,6:--", "1:5:1,5,6,0,2:--", "1:4:1,5,6,7:---", "1:4:1,5,6,1:--"}, delimiter = ':')
    public void skidMarkTest(Integer carNumber, Integer playCount, String commaString, StringBuilder resultMark) {
        List<Integer> numbers = Arrays.stream(commaString.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        TestRacingGame testRacingGame = new TestRacingGame();
        testRacingGame.updateNumbers(numbers);
        testRacingGame.execute(new RacingInfomation(carNumber, playCount));
        StringBuilder result = testRacingGame.gameProgress();

        resultMark.append(System.lineSeparator());
        assertThat(result.toString()).isEqualTo(resultMark.toString());
    }

    @DisplayName("자동차 공장(carFactory) 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void factoryCreateTest(Integer input) {
        List<Car> cars = racingCarFactory.createCars(input);
        assertThat(cars.size()).isEqualTo(input);

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            carList.add(racingCarFactory.createCar());
        }
        assertThat(carList.size()).isEqualTo(input);
    }

    @DisplayName("레이싱게임 정보 null 테스트")
    @ParameterizedTest
    @NullSource
    public void nullAndEmptyRacingTest(RacingInfomation input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingGame.execute(input))
                .withMessageStartingWith("빈 공백");
    }

}
