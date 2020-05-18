package racingGame.domain;

public class RacingCar {

	private String MOVE = "-";
	private String STOP = "";

	public String move() {
		Movable movable = new RandomMovable();
		if(movable.checkMovable()) {
			return MOVE;
		}
		return STOP;
	}
}
