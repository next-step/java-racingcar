package racingcar.step3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.domain.Car;
import racingcar.step3.domain.Cars;
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
    Record record;
    String inputNames;
    Cars cars;
    String[] names;
    List<Car> carList = null;

    @BeforeEach
    void setUp() {
        this.record = new Record();
        this.inputNames = "pobi,crong,honux";
        this.cars = new Cars(inputNames, record);
        this.names = inputNames.split(",");
        this.carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    @Test
    @DisplayName("턴 승자 확인")
    void execRoll_thenGetWinner() {
        int turn = 1;
        for (Car car : cars.getCars()) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                record.record(car, turn);
                cars.setWinner(car);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        assertThat(cars.getWinner()).isNotEmpty();
    }

    @Test
    @DisplayName("턴 기록 확인")
    void execRoll_thenGetRecord() {
        int turn = 1;
        for (Car car : carList) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                record.record(car, turn);
                cars.setWinner(car);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        assertThat(record.getTotalRecords()).isNotEmpty();
        assertThat(record.getTotalRecords()).hasSize(turn);
        assertThat(record.getTotalRecords().get(1)).hasSize(names.length);
        assertThat(record.getBestRecord()).isBetween(0, 1);
    }

    @Test
    @DisplayName("전체 기록 확인")
    void execRun_thenGetRecords() {
        Race race = new Race();
        int turn = 5;
        race.run(cars, turn, record);
        assertThat(cars.getWinner()).isNotEmpty();
        assertThat(record.getTotalRecords()).hasSize(turn);
        assertThat(record.getTotalRecords().get(turn)).hasSize(names.length);
        assertThat(record.getBestRecord()).isBetween(0, turn);
    }

}