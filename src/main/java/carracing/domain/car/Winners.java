package carracing.domain.car;

public class Winners {
	private final Cars winners;

	public Winners(Cars winners) {
		this.winners = winners;
	}

	public void printWinners() {
		winners.printWinners();
	}

	public boolean isWinners(Cars cars) {
		return this.winners.equals(cars);
	}
}
