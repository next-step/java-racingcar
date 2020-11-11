package racingcar.step3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.common.Consts;
import racingcar.step3.domain.Car;
import racingcar.step3.domain.Race;
import racingcar.step3.domain.Record;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-02 오후 12:41.
 * Developer : Seo.
 */
class RaceTest {
    String cars;
    String[] names;
    Record record;
    List<Car> carList = null;

    @BeforeEach
    void setUp() {
        record = new Record(Consts.BEST_RECORD_INIT, Consts.WINNER_INIT);
        cars = "pobi,crong,honux";

        names = cars.split(",");
        carList = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            carList.add(new Car(names[i]));
        }
    }

    @Test
    @DisplayName("턴 승자 확인")
    void execRoll_thenGetWinner() {
        int turns = 1;
        for (Car car : carList) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                record.record(turns, car);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        assertThat(record.getWinner()).isNotEmpty();
    }

    @Test
    @DisplayName("턴 기록 확인")
    void execRoll_thenGetRecord() {
        int turns = 1;
        for (Car car : carList) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                record.record(turns, car);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        assertThat(record.getTotalRecords()).hasSize(turns);
        assertThat(record.getTotalRecords().get(1).size()).isEqualTo(names.length);
    }

    @Test
    @DisplayName("전체 기록 확인")
    void execRun_thenGetRecords() {
        Race race = new Race();
        int turns = 5;
        race.run(cars, turns, record);
        assertThat(record.getWinner()).isNotEmpty();
        assertThat(record.getTotalRecords()).hasSize(turns);
        assertThat(record.getTotalRecords().get(turns).size()).isEqualTo(names.length);
    }

}