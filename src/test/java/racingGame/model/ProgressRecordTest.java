package racingGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProgressRecordTest {
    
    ProgressRecord progressRecord;
    
    @Test
    void recordIsEmptyTest() {
        List<Car> joinCarsRecord = new ArrayList<>();
        progressRecord = new ProgressRecord(joinCarsRecord);
        assertThat(progressRecord.joinCars()).isEmpty();
    }
    
    @Test
    void gameRecordTest() {

        List<Car> joinCarsRecord = new ArrayList<>();
        joinCarsRecord.add(new Car("pobi"));
        joinCarsRecord.add(new Car("crong"));
        joinCarsRecord.add(new Car("honux"));
        progressRecord = new ProgressRecord(joinCarsRecord);

        assertThat(progressRecord.joinCars().size()).isEqualTo(3);
    }
    
    @Test
    void showGameResultTest() {
        List<Car> joinCars = new ArrayList<>();
        joinCars.add(new Car("pobi"));
        joinCars.add(new Car("crong"));
        progressRecord = new ProgressRecord(joinCars);
        assertThat(progressRecord.joinCars()).isNotEmpty();
    }

    @Test
    void carNameTest() {
        String pobi = "pobi";
        String crong = "crong";
        String honux = "honux";

        List<Car> joinCars = new ArrayList<>();
        joinCars.add(new Car(pobi));
        joinCars.add(new Car(crong));
        joinCars.add(new Car(honux));
        progressRecord = new ProgressRecord(joinCars);

        assertThat(progressRecord.joinCars().size()).isEqualTo(3);
        progressRecord.joinCars().get(0).getName().equals(pobi);
        progressRecord.joinCars().get(1).getName().equals(crong);
        progressRecord.joinCars().get(2).getName().equals(honux);
    }
    
}