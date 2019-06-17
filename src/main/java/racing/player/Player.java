package racing.player;

import racing.car.RacingCar;

public abstract class Player {

	private RacingCar car;

	Player(RacingCar car){
		this.car = car;
	}

	public abstract void drive();

	public int getPosition(){
		return car.getMileage();
	};

	protected RacingCar getCar(){
		return this.car;
	}
}
