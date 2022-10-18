package step5.model;

public class TryCount {
	private static final int MIN_TRY_CNT = 1;

	private final int count;

	public TryCount(int count) {
		checkValidation(count);
		this.count = count;
	}

	private void checkValidation(int count){
		if(count < MIN_TRY_CNT){
			throw new IllegalArgumentException("시도 횟수는 적어도 양수여야 합니다.");
		}
	}

	public int getCount() {
		return count;
	}
}
