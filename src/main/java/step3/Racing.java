package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
	
	private static final int minimumRacingCar = 2;
	private static final int minimumRacingRound = 1;
	
	private List<Car> cars;
	
	Racing(int racingCars, int racingRound) {
		validationRound(racingRound);
		validationCars(racingCars);
		createRacingCars(racingCars);
	}

    private void createRacingCars(int racingCars){
    	this.cars = Stream.generate(Car::new)
    			.limit(racingCars)
    			.collect(Collectors.toList());
    }

	private void validationRound(int racingRound) {
		if(racingRound < minimumRacingRound) {
			throw new IllegalArgumentException("최소 1바퀴 이상이어야 경주가 가능합니다.");
		}
	}
	
    private void validationCars(int racingCars) {
    	if(racingCars < minimumRacingCar) {
    		throw new IllegalArgumentException("최소 2대 이상이어야 경주가 가능합니다.");
    	}
    }
    
    public List<Car> gameStart(){
    	for(Car car : this.cars) {
    		car.tryToMove(ValueGenerator.randomValue());
    	}
		return cars;
    }
    
}