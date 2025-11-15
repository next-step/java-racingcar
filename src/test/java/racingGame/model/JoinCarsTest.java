package racingGame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class JoinCarsTest {
    
    @Test
    void addJoinCarsTest() {
        List<Car> cars = List.of(new Car("pobi"));
        JoinCars joinCars = new JoinCars(cars);
        joinCars.addJoinCars(new Car("mo"));
        
        List<Car> expectedCars = List.of(new Car("pobi"),new Car("mo"));
        JoinCars expectedJoinCars = new JoinCars(expectedCars);
        
        assertThat(joinCars).isEqualTo(expectedJoinCars);
    }
    
    
    @Test
    void findJointWinnersTest() {
        List<Car> joinCars = new ArrayList<>();
        joinCars.add(new Car("pobi",5));
        joinCars.add(new Car("crong",5));
        joinCars.add(new Car("mo",3));
        joinCars.add(new Car("jae",2));
        JoinCars jc = new JoinCars(joinCars);
        
        List<Car> expectWinnerCars = List.of(new Car("pobi",5), new Car("crong",5));
        JoinCars expectedJc = new JoinCars(expectWinnerCars);
        assertThat(jc.findWinners()).isEqualTo(expectedJc);
    }
    
    @Test
    void findSoleWinnersTest() {
        List<Car> joinCars = new ArrayList<>();
        joinCars.add(new Car("pobi",4));
        joinCars.add(new Car("crong",5));
        joinCars.add(new Car("mo",3));
        joinCars.add(new Car("jae",2));
        JoinCars jc = new JoinCars(joinCars);
        
        List<Car> expectWinnerCars = List.of(new Car("crong",5));
        JoinCars expectedJc = new JoinCars(expectWinnerCars);
        assertThat(jc.findWinners()).isEqualTo(expectedJc);
    }
    
}