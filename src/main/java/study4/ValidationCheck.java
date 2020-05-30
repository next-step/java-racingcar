package study4;

public class ValidationCheck {

	public void carNameCheck(String carName) {
		if (carName.equals("") || carName.equals(" ")) {
			throw new IllegalArgumentException("자동차이름을 다시 입력해주세요.");
		}
		
		if (!carName.contains(",")) {
			throw new IllegalArgumentException("이름을 ,로 구분지어 주세요");
		}
	}

	public void moveCountCheck(int movenum) {
		if (movenum < 1) {
			throw new IllegalArgumentException("자동차 게임에서 최대 1대이상의 시도 횟수를 입력해야 됩니다.");
		}
	}
}
