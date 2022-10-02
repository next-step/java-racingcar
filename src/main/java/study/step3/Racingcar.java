package study.step3;

public class Racingcar {
	private int position;

	public Racingcar() {}

	// 자동차의 초기 점수는 0
	public void initPosition() {
		this.position = 0;
	}

	// 자동차의 점수가 1 증가
	public void move() {
		this.position++;
	}

	public int getPosition() {
		return this.position;
	}
}
