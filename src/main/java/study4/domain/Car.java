package study4.domain;

public class Car {

	private String carName; // 자동차 이름
	private int position; // 자동차 위치정보
	private static String move = "-";

	public Car(String carName) {
		this(carName, 0);
	}

	public Car(String carName, int position) {
		this.carName = carName;
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarName() {
		return carName;
	}

	public int move(int inNum) {
		if (inNum >= 4) {
			return position += 1;
		}
		return position;
	}

	public void outputnumCarResult(Car car) {
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print(move);
		}
		System.out.println();
	}
}
