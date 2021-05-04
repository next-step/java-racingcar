package racing;

public class Car {
	public static final int CAR_NAME_MAX_LENGTH = 5;
	public static final String PROGRESS_BAR = "-";

	private String name;
	private MoveStatus status;
	private int moveCount;

	public Car(String name) {
		if (name.isEmpty() || name.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("자동차의 이름 길이는 0보다 크고 5보다 작거나 같아야 합니다 : " + name);
		}
		this.name = name;
		this.status = MoveStatus.STOP;
	}

	public String getName() {
		return name;
	}

	public MoveStatus getMovementStatus() {
		return this.status;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void move(MoveCondition condition) {
		this.status = condition.getStatus();
		if (condition.getStatus().equals(MoveStatus.FORWARD)) {
			this.moveCount++;
			System.out.printf("<<%s %s>>%n", getName(), MoveStatus.FORWARD);
		}
	}

	public void print() {
		StringBuilder stb = new StringBuilder(String.format("%s : ", getName()));
		for (int i = 0; i < moveCount; i++) {
			stb.append(PROGRESS_BAR);
		}
		System.out.println(stb.toString());
	}
}
