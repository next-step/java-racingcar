package racingGame.Business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingGame.model.Car;

class ProcessTest {
    
    Process gp;
    
    @BeforeEach
    void setUp() {
        gp = new Process();
    }
    
    @Test
    void carGenerateResultTest() {
        gp.run(3,1);
        assertThat(gp.joinCars().size()).isEqualTo(3);
    }

  @Test
  void carForwardTest() {
      gp.run(1, 10);
      while(true) {
          if(gp.joinCars().getFirst().findLocation() > 0) {
              break;
          }
      }

      assertThat(gp.joinCars().getFirst().findLocation()).isNotEqualTo(0);
  }

 @Test
 void carsForwardTest() {
     gp.run(3, 10);
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