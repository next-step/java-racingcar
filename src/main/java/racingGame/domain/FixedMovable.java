package racingGame.domain;

public class FixedMovable implements Movable {

	private int moveNumber;
	private int MOVABLENUMBER = 4;
	
	public FixedMovable(int moveNumber) {
		this.moveNumber = moveNumber;
	}

	@Override
	public boolean checkMovable() {
		return moveNumber >= MOVABLENUMBER;
	}
}
