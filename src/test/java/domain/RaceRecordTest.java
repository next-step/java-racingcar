package domain;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RaceRecordTest {
    @Test
    @Order(1)
    void 우승자는_한명_이상일수_있다() {
        List<Car> carsList = new ArrayList<>();
        RaceRecord raceRecord = new RaceRecord();
        carsList.add(new Car("win", 10));
        carsList.add(new Car("win2", 10));
        carsList.add(new Car("lose", 9));
        Cars cars = new Cars(carsList, new RaceCondition());
        raceRecord.addRecord(cars);

        assertThat(raceRecord.getRaceWinners()).isEqualTo("win,win2");
    }

    @Test
    @Order(2)
    void 우승자_한명_확인() {
        List<Car> carsList = new ArrayList<>();
        RaceRecord raceRecord = new RaceRecord();
        carsList.add(new Car("win", 10));
        carsList.add(new Car("win2", 7));
        carsList.add(new Car("lose", 9));
        Cars cars = new Cars(carsList, new RaceCondition());
        raceRecord.addRecord(cars);

        assertThat(raceRecord.getRaceWinners()).isEqualTo("win");
    }
}