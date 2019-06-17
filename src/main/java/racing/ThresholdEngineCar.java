package racing;

public class ThresholdEngineCar extends RacingCar{

	private int thresholdAmount = 0;

	public ThresholdEngineCar(int thresholdAmount){
		this.thresholdAmount = thresholdAmount;
	}

	@Override
	public void accelerate(int amount) {
		this.addMileage(amount > thresholdAmount ? 1 : 0);
	}
}
