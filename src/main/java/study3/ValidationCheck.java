package study3;

public class ValidationCheck {

	public void carNumberCheck(int carnum) {
		if (carnum < 1) {
			throw new IllegalArgumentException("자동차 게임에서 최대 1대이상의 자동차를 입력해야 됩니다.");
		}

	}

	public void moveCountCheck(int movenum) {
		if (movenum < 1) {
			throw new IllegalArgumentException("자동차 게임에서 최대 1대이상의 시도 횟수를 입력해야 됩니다.");
		}
	}
}
