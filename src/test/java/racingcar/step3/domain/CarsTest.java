package racingcar.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.common.Consts;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-12 오후 1:22
 * Developer : Seo
 */
class CarsTest {
    Car car1;
    Car car2;
    Car car3;
    Record record;
    Cars cars;
    String inputNames;

    @BeforeEach
    void setUp() {
        this.car1 = new Car("pobi");
        this.car2 = new Car("crong");
        this.car3 = new Car("honux");
        this.record = new Record();
        this.inputNames = "pobi,crong,honux";
        this.cars = new Cars(inputNames, record);
    }

    @Test
    @DisplayName("승자는 한 명")
    void givenTheOnlyOneBestRecord_thenGetWinner() {
        int turn = 1;
        car1.move(Consts.INVALID_VALUE + 1);
        record.record(car1, turn);
        cars.setWinner(car1);

        car2.move(Consts.INVALID_VALUE);
        record.record(car2, turn);
        cars.setWinner(car2);

        car3.move(Consts.INVALID_VALUE);
        record.record(car3, turn);
        cars.setWinner(car3);

        assertThat(cars.getWinner()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("승자는 두 명")
    void givenTwoBestRecord_thenGetWinners() {
        int turn = 1;
        car1.move(Consts.INVALID_VALUE + 1);
        record.record(car1, turn);
        cars.setWinner(car1);

        car2.move(Consts.INVALID_VALUE + 1);
        record.record(car2, turn);
        cars.setWinner(car2);

        car3.move(Consts.INVALID_VALUE);
        record.record(car3, turn);
        cars.setWinner(car3);

        assertThat(cars.getWinner()).isEqualTo("pobi, crong");
    }

    @Test
    @DisplayName("모두가 승자")
    void givenAllBestRecord_thenGetWinners() {
        int turn = 1;
        car1.move(Consts.INVALID_VALUE + 1);
        record.record(car1, turn);
        cars.setWinner(car1);

        car2.move(Consts.INVALID_VALUE + 1);
        record.record(car2, turn);
        cars.setWinner(car2);

        car3.move(Consts.INVALID_VALUE + 1);
        record.record(car3, turn);
        cars.setWinner(car3);

        assertThat(cars.getWinner()).isEqualTo("pobi, crong, honux");
    }

    @Test
    @DisplayName("승자는 없음")
    void givenNothingBestRecord_thenGetWinners() {
        int turn = 1;
        car1.move(Consts.INVALID_VALUE);
        this.record.record(car1, turn);

        car2.move(Consts.INVALID_VALUE);
        this.record.record(car2, turn);

        car3.move(Consts.INVALID_VALUE);
        this.record.record(car3, turn);

        assertThat(cars.getWinner()).isEmpty();
    }

}