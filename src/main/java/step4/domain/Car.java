package step4.domain;

public class Car {
	public static int DEFAULT_SPEED = 1;
	public static int STOP_SPEED = 0;

	private Integer position;
	private CarMoveStrategy moveStrategy;

	public Car() {
		this.position = 0;
		this.moveStrategy = new CarAtDefaultStrategy(); // 기본 전략 지정
	}

	public void move(Integer randVal) {
		this.position += this.moveStrategy.getMovePosition(randVal);
	}

	public int getPosition() {
		return position;
	}

	public void setMoveStrategy(CarMoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}
}
