package racingGame.Business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.Car;

class ProcessTest {
    
    Process gp;
    
    @BeforeEach
    void setUp() {
        gp = new Process();
    }
    
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void carGenerateResultTest(int cars) {
        assertThat(gp.run(cars,1)
            .getFirst().progressRecords()
            .getFirst().carRecord().size())
            .isEqualTo(cars);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {8, 9, 10, 11})
    void carForwardTest(int moves) {
      gp.run(1, moves);
      while(true) {
          if(gp.joinCars().getFirst().findLocation() > 0) {
              break;
          }
      }
      assertThat(gp.joinCars().getFirst().findLocation()).isNotEqualTo(0);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"3:5", "4:6", "6:8", "8:10"}, delimiter = ':')
    void carsForwardTest(int cars, int moves) {
     gp.run(cars, moves);
     while(true) {
         if(gp.joinCars().getFirst().findLocation() > 2) {
             break;
         }
     }
     for(Car car : gp.joinCars()){
         assertThat(car.findLocation()).isNotEqualTo(0);
     }
    }
}