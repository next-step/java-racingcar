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
        JoinCars joinCars = new JoinCars(joinCarsRecord);
        progressRecord = new ProgressRecord(joinCars);
        assertThat(progressRecord.joinCars().cars()).isEmpty();
    }
    
    @Test
    void gameRecordTest() {

        List<Car> joinCarsRecord = new ArrayList<>();
        joinCarsRecord.add(new Car("pobi"));
        joinCarsRecord.add(new Car("crong"));
        joinCarsRecord.add(new Car("honux"));
        JoinCars joinCars = new JoinCars(joinCarsRecord);
        progressRecord = new ProgressRecord(joinCars);
        
        assertThat(progressRecord.joinCars().cars()).hasSize(3);
    }
    
    @Test
    void showGameResultTest() {
        List<Car> joinCarsRecord = new ArrayList<>();
        joinCarsRecord.add(new Car("pobi"));
        joinCarsRecord.add(new Car("crong"));
        JoinCars joinCars = new JoinCars(joinCarsRecord);
        progressRecord = new ProgressRecord(joinCars);
        assertThat(progressRecord.joinCars().cars()).isNotEmpty();
    }

    @Test
    void carNameTest() {
        String pobi = "pobi";
        String crong = "crong";
        String honux = "honux";

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(pobi));
        cars.add(new Car(crong));
        cars.add(new Car(honux));
        JoinCars joinCars = new JoinCars(cars);
        progressRecord = new ProgressRecord(joinCars);

        assertThat(progressRecord.joinCars().cars().size()).isEqualTo(3);
        progressRecord.joinCars().cars().get(0).getName().equals(pobi);
        progressRecord.joinCars().cars().get(1).getName().equals(crong);
        progressRecord.joinCars().cars().get(2).getName().equals(honux);
    }
    
}