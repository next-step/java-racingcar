package racingGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingGame.business.GameMove;

class ProgressRecordTest {
    
    ProgressRecord progressRecord;
    
    @BeforeEach
    void setUp() {
        progressRecord = new ProgressRecord();
    }
    
    @Test
    void recordIsEmptyTest() {
        assertThat(progressRecord.carRecord()).isEmpty();
    }
    
    @Test
    void gameRecordTest() {

        List<Car> joinCarsRecord = new ArrayList<>();
        joinCarsRecord.add(new Car("pobi"));
        joinCarsRecord.add(new Car("crong"));
        joinCarsRecord.add(new Car("honux"));
        progressRecord.recordGame(joinCarsRecord);

        assertThat(progressRecord.carRecord().size()).isEqualTo(3);
    }
    
    @Test
    void findJointWinnersTest() {
        List<Car> joinCars = new ArrayList<>();
        joinCars.add(new Car("pobi",5));
        joinCars.add(new Car("crong",5));
        joinCars.add(new Car("mo",3));
        joinCars.add(new Car("jae",2));
        progressRecord.recordGame(joinCars);
        
        List<String> winner = List.of("pobi", "crong");
        
        assertThat(progressRecord.findWinners()).isEqualTo(winner);
    }
    
    @Test
    void findSoleWinnersTest() {
        List<Car> joinCars = new ArrayList<>();
        joinCars.add(new Car("pobi",4));
        joinCars.add(new Car("crong",5));
        joinCars.add(new Car("mo",3));
        joinCars.add(new Car("jae",2));
        progressRecord.recordGame(joinCars);
        
        List<String> winner = List.of("crong");
        
        assertThat(progressRecord.findWinners()).isEqualTo(winner);
    }
    
    @Test
    void showGameResultTest() {
        List<Car> joinCarsRecord = new ArrayList<>();
        joinCarsRecord.add(new Car("pobi"));
        joinCarsRecord.add(new Car("crong"));
        progressRecord.recordGame(joinCarsRecord);
        assertThat(progressRecord.carRecord()).isNotEmpty();
    }

    @Test
    void carNameTest() {
        String pobi = "pobi";
        String crong = "crong";
        String honux = "honux";

        List<Car> joinCarsRecord = new ArrayList<>();
        joinCarsRecord.add(new Car(pobi));
        joinCarsRecord.add(new Car(crong));
        joinCarsRecord.add(new Car(honux));
        progressRecord.recordGame(joinCarsRecord);

        assertThat(progressRecord.carRecord().size()).isEqualTo(3);
        progressRecord.carName().get(0).equals(pobi);
        progressRecord.carName().get(1).equals(crong);
        progressRecord.carName().get(2).equals(honux);
    }
}