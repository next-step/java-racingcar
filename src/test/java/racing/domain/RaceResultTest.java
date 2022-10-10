package racing.domain;

import org.junit.jupiter.api.Test;
import racing.domain.car.AlwaysMovingStrategy;
import racing.domain.car.Car;
import racing.domain.race.RaceResult;
import racing.domain.race.Record;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {

    @Test
    void 레코드_등록_테스트() {
        Car 빵빵이 = new Car(new AlwaysMovingStrategy(), "빵빵이");
        빵빵이.move();
        빵빵이.move();

        RaceResult raceResult = new RaceResult();
        raceResult.addRecord(빵빵이);

        assertThat(raceResult).isEqualTo(
            new RaceResult(
                List.of(
                    new Record("빵빵이", 2)
                )
            )
        );
    }

    @Test
    void 기록중_가장_멀리간_기록_조회() {
        Record 빵빵이 = new Record("빵빵이", 5);
        Record 씽씽이 = new Record("씽씽이", 4);
        Record 쌩쌩이 = new Record("쌩쌩이", 5);
        RaceResult raceResult = new RaceResult(
            List.of(빵빵이, 씽씽이, 쌩쌩이)
        );

        assertThat(raceResult.winners())
            .hasSize(2)
            .containsExactly(빵빵이, 쌩쌩이);
    }

}