package step4.domain.movestrategy;

public class AlwaysMoveStrategy implements CarMoveStrategy {
	public AlwaysMoveStrategy() {
	}

	@Override
	public boolean movable() {
		return true;
	}
}
