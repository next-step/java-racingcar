package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

    private static final String CAR_NAMES = "damas,bmw,benz";
    private static final String SPLIT_CHARACTER = ",";
    private static final int RACING_COUNT = 5;
    private static final int NEGATIVE_QUANTITY = -1;
    private static final RacingGame racingGame = new RacingGame(CAR_NAMES, RACING_COUNT);


    @ParameterizedTest
    @DisplayName("경기를 n번 진행하면, n개의 record가 쌓인다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void should_save_records_when_playing_4_matches(int racingCount) {
        //Given
        RacingGame newRacingGame = new RacingGame(CAR_NAMES, racingCount);

        //When
        List<Cars> start = newRacingGame.start();

        //Then
        assertThat(start.size()).isEqualTo(racingCount);

    }

    @Test
    @DisplayName("레이싱 횟수가 양수가 아니면, IllegalArgumentException을 던진다")
    void should_throw_Illegal_argument_exception_when_racing_count_is_negative_quantity() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new RacingGame(CAR_NAMES, NEGATIVE_QUANTITY);
                })
                .withMessage("racing count is not available");
    }

    @ParameterizedTest
    @DisplayName("racingCarNames가 공백이거나 \"\" 이면, IllegalArgumentException을 던진다")
    @ValueSource(strings = {"", " "})
    void should_throw_Illegal_argument_exception_when_racing_car_names_is_blank(String carNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new RacingGame(carNames, RACING_COUNT);
                })
                .withMessage("racing car name is wrong");
    }

    @Test
    @DisplayName("주어진 이름에 맞는 자동차들을 반환한다")
    public void should_return_cars_by_names_of_cars() {
        //Given & When
        Cars cars = racingGame.createCars();

        //Then
        assertThat(cars.getCarNames()).containsAll(splitCarNames());
    }

    @Test
    @DisplayName("주어진 이름에 없는 자동차는 반환하지 않는다")
    public void should_not_return_cars_not_in_car_names() {
        //Given & When
        Cars cars = racingGame.createCars();

        //Then
        assertThat(cars.getCarNames()).doesNotContain("k5").isNotEmpty();
    }

    @Test
    @DisplayName("자동차들 중 우승자(들)를 반환한다")
    void should_return_winners() {
        //Given
        List<Cars> cars = getRacingGameResult();

        //When
        Cars winners = racingGame.getWinners(cars);

        //Then
        assertThat(winners.getCarNames())
                .containsAll(Lists.newArrayList("damas", "bmw"));

    }

    @Test
    @DisplayName("자동차들 중 우승자가 아니면 반환하지 않는다")
    void should_not_return_winners() {
        //Given
        Cars cars = getRacingGameResult();

        //When
        Cars winners = racingGame.getWinners(cars);

        //Then
        assertThat(winners.getCarNames()).doesNotContain("benz").isNotEmpty();

    }

    private List<String> splitCarNames() {
        return Arrays.stream(RacingGameTest.CAR_NAMES.split(SPLIT_CHARACTER)).collect(Collectors.toList());
    }

    private Cars getRacingGameResult() {
        List<Car> carList = new ArrayList<>();

        Name damas = new Name("damas");
        Name bmw = new Name("bmw");
        Name benz = new Name("benz");

        Position winner = new Position(3);
        Position loser = new Position(0);

        carList.add(new Car(damas, winner));
        carList.add(new Car(bmw, winner));
        carList.add(new Car(benz, loser));

        return new Cars(carList);
    }

}