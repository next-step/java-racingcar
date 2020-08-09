package step3;

import java.util.ArrayList;
import java.util.List;

public class Racing {
	
	private static final int minimumRacingCar = 2;
	private static final int minimumRacingRound = 1;
	
	private List<Car> cars;
	
	Racing(int racingCars, int racingRound) {
		validationRound(racingRound);
		validationCars(racingCars);
		setRacingCars(racingCars);
	}

    private void setRacingCars(int racingCars){
    	List<Car> cars = new ArrayList<Car>();
    	for(int i = 0; i < racingCars; i++) {
    		cars.add(new Car());
    	}
    	this.cars = cars;
    }
    
	public List<Car> getRacingCars(){
		return this.cars;
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
    
    public List<Car> setRacingResult(List<Car> cars){
    	for(int i = 0; i < cars.size(); i++) {
    		cars.get(i).tryToMove(ValueGenerator.randomValue());
    	}
    	return this.cars;
    }
}