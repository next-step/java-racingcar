package study.step3;

public class Racingcar {
	private int score;

	public Racingcar() {}

	// 자동차의 초기 점수는 0
	public void setInitScore() {
		this.score = 0;
	}

	// 자동차의 점수가 1 증가
	public void addScore() {
		this.score++;
	}

	public int getScore() {
		return this.score;
	}
}
