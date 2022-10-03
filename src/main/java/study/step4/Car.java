package study.step4;

public class Car {
	private String name;	// 자동차 이름
	private int position;	// 자동차 현재 위치

	public Car() {}

	public void checkName(String name) {
		int MAX_NAME_LENGTH = 5;
		if(name.length() > MAX_NAME_LENGTH){
			throw new BadRequestException("이름은 5글자를 초과할 수 없습니다.");
		}
	}

	public String setName(String name) {
		checkName(name);
		this.name = name;
		return name;
	}

	public String getName() {
		return this.name;
	}

	// 자동차의 초기 위치는 0
	public void initPosition() {
		this.position = 0;
	}

	// 자동차의 위치가 1 증가
	public void move() {
		this.position++;
	}

	public int getPosition() {
		return this.position;
	}

	public void printName() {
		System.out.print(this.getName() + " : ");
	}

	public void printPosition() {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
