package racing.car;

import racing.car.RacingCar;

public class ThresholdEngineCar extends RacingCar {

	private static int DEFAULT_THRESHOLD = 4;

	private int thresholdAmount;

	public ThresholdEngineCar(){
		this(DEFAULT_THRESHOLD);
	}

	public ThresholdEngineCar(int thresholdAmount){
		this.thresholdAmount = thresholdAmount;
	}

	@Override
	public void accelerate(int amount) {
		this.addMileage(amount > thresholdAmount ? 1 : 0);
	}
}
