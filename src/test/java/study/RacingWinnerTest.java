package study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingWinner.Car;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingWinner.RacingGame.getMaxLocationWithList;
import org.junit.jupiter.api.Test;
public class RacingWinnerTest {
	 
	private List<Car> carsList;
	private String[] carNamesArrayTrue;
	private String[] carNamesArrayFalse;
	
	@BeforeEach
    void setUp() {
        carsList = new ArrayList<>();
        Car car = new Car("pobi");
        car.go(5);
        carsList.add(car);
        
        Car car2 = new Car("crong");
        car.go(5);
        car.go(5);
        car.go(5);
        carsList.add(car2);
        
        Car car3 = new Car("honux");
        car.go(5);
        car.go(5);
        car.go(5);
        car.go(5);
        car.go(5);
        carsList.add(car3);
        
        carNamesArrayTrue = new String[3];
        carNamesArrayTrue[0] = "calc";
        carNamesArrayTrue[1] = "apple";
        carNamesArrayTrue[2] = "tree";
        
        carNamesArrayFalse = new String[4];
        carNamesArrayFalse[0] = "calc";
        carNamesArrayFalse[1] = "banana";
        carNamesArrayFalse[2] = "apple";
        carNamesArrayFalse[3] = "tree";
        
       
    }
	@Test
	public void condition() {
//		assertThat(runOrStopCondition(3)).isEqualTo(false);
//		assertThat(runOrStopCondition(9)).isEqualTo(true);
	}
//	
	@Test
	public void go()
	{
		Car car = carsList.get(0);
		assertThat(car.getLocation()).isEqualTo(1);
		car.go(5);
		assertThat(car.getLocation()).isEqualTo(2);
	}

	
	@Test
	public void checkName() {
		assertThatThrownBy(() -> {
			Car car = new Car("lengthOver");
		}).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void checkMaxLocationWithList() {
		assertThat(getMaxLocationWithList(carsList)).isEqualTo(5);
	}
	
}
