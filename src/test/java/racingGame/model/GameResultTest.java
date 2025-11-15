package racingGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameResultTest {
    
    GameResult gameResult;
    
    @Test
    void getGameResultTest() {
        List<Car> cars = new ArrayList<>();
        
        List<ProgressRecord> progressRecords = new ArrayList<>();
        progressRecords.add(new ProgressRecord(cars));
        gameResult = new GameResult(progressRecords);
        assertThat(gameResult.progressRecords().size()).isEqualTo(1);
    }
    
    @Test
    void findJointWinnersTest() {
        List<Car> joinCars = new ArrayList<>();
        joinCars.add(new Car("pobi",5));
        joinCars.add(new Car("crong",5));
        joinCars.add(new Car("mo",3));
        joinCars.add(new Car("jae",2));
        ProgressRecord progressRecord = new ProgressRecord(joinCars);
        List<ProgressRecord> progressRecords = List.of(progressRecord);
        GameResult gameResult = new GameResult(progressRecords);
        
        List<Car> winner = List.of(new Car("pobi",5), new Car("crong",5));
        
        assertThat(gameResult.findWinners()).isEqualTo(winner);
    }
    
    @Test
    void findSoleWinnersTest() {
        List<Car> joinCars = new ArrayList<>();
        joinCars.add(new Car("pobi",4));
        joinCars.add(new Car("crong",5));
        joinCars.add(new Car("mo",3));
        joinCars.add(new Car("jae",2));
        ProgressRecord progressRecord = new ProgressRecord(joinCars);
        List<ProgressRecord> progressRecords = List.of(progressRecord);
        GameResult gameResult = new GameResult(progressRecords);
        
        List<Car> winner = List.of(new Car("crong",5));
        
        assertThat(gameResult.findWinners()).isEqualTo(winner);
    }
}