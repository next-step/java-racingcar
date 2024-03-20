package racingcar;

public class Car {
	private final String name;
	private int position;
	private final CarMoveStrategy[] carMoveStrategies;

	public Car (String name, CarMoveStrategy... carMoveStrategies) {
		checkName(name);

		this.name = name;
		position = 0;
		this.carMoveStrategies = carMoveStrategies;
	}

	public void move() {
		for(CarMoveStrategy carMoveStrategy : carMoveStrategies) {
			if(!carMoveStrategy.isMovable()) {
				return;
			}
		}
		position++;
	}

	public boolean isEqualPosition(int position) {
		return this.position == position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private void checkName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("이름은 빈 값일 수 없습니다. 다시 입력해주세요");
		}

		if(name.length() > 5) {
			throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.");
		}
	}
}
