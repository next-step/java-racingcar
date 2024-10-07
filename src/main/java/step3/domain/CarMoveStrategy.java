package step3.domain;

public interface CarMoveStrategy {
	Integer speed();

	Integer getMovePosition(Integer randVal);
}
