package study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingWinner.Car;
import static racingWinner.RunOrStop.runOrStopCondition;
import static racingWinner.RunOrStop.runOrStop;
import static org.assertj.core.api.Assertions.assertThat;
import static racingWinner.MakeCar.checkMaxLength;
import static racingWinner.MakeCar.makeCarsCondition;
import static racingWinner.RunOrStop.getMaxLocation;
import static racingWinner.RunOrStop.getMaxLocationWithList;
import org.junit.jupiter.api.Test;
public class RacingWinnerTest {
	
	private List<Car> carsList;
	private String[] carNamesArrayTrue;
	private String[] carNamesArrayFalse;
	
	@BeforeEach
    void setUp() {
        carsList = new ArrayList<>();
        Car car = new Car();
        car.setCarName("pobi");
        car.setLocation(1);
        carsList.add(car);
        
        Car car2 = new Car();
        car2.setCarName("crong");
        car2.setLocation(3);
        carsList.add(car2);
        
        Car car3 = new Car();
        car3.setCarName("honux");
        car3.setLocation(5);
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
	public void Á¶°Ç() {
		assertThat(runOrStopCondition(3)).isEqualTo(false);
		assertThat(runOrStopCondition(9)).isEqualTo(true);
	}
//	
	@Test
	public void ¸ØÃãÀüÁø()
	{
		Car car = carsList.get(0);
		assertThat(car.getLocation()).isEqualTo(1);
		car = runOrStop(5, car);
		assertThat(car.getLocation()).isEqualTo(2);
	}

		
	public void ¿ì½Â(){
		
		
	}
	
	
	@Test
	public void checkName() {
		assertThat(checkMaxLength("length")).isEqualTo(false);
//		assertThat(checkMaxLength("short")).isEqualTo(false);
		assertThat(checkMaxLength("short")).isEqualTo(true);
	}
	
	@Test
	public void checkNameArray() {
		assertThat(makeCarsCondition(carNamesArrayTrue)).isEqualTo(true);
		assertThat(makeCarsCondition(carNamesArrayFalse)).isEqualTo(false);
	}
	
	@Test
	public void checkMaxLocation() {
		assertThat(getMaxLocation(4, carsList.get(2))).isEqualTo(4);
		assertThat(getMaxLocation(4, carsList.get(0))).isEqualTo(4);
	}
	
	@Test
	public void checkMaxLocationWithList() {
		assertThat(getMaxLocationWithList(carsList)).isEqualTo(5);
	}
	
}
