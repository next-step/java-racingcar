package step5_racingcar_refactoring.service;

import java.util.LinkedHashSet;
import java.util.Set;

import step5_racingcar_refactoring.domain.Car;
import step5_racingcar_refactoring.domain.Cars;

public class Winner {

	Set<Car> winners = new LinkedHashSet<>();

	private int maxValue = 0;
	public Set<Car> findWinners(Cars cars)
	{
		for(Car car : cars.getCars())
		{
			setWinner(car);
		}

		return winners;
	}

	private void setWinner(Car car)
	{
		if (car.getPosition() > this.maxValue) {
			winners.clear();
			this.maxValue = car.getPosition();
			winners.add(car);
			return;
		}

		if (car.getPosition() == this.maxValue) {
			this.maxValue = car.getPosition();
			winners.add(car);
			return;
		}

		if (winners.contains(car)) {
			winners.remove(car);
			return;
		}
	}

	public Set<String>  getNames()
	{
		Set<String> winnerNameSet = new LinkedHashSet<>();
		for(Car car : winners)
		{
			winnerNameSet.add(car.getName());
		}
		return winnerNameSet;
	}
}
