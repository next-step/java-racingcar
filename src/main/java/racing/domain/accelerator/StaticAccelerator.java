package racing.domain.accelerator;

/**
 * 생성자에 전달된 값을 가속 가중치로 반환하는 가속기
 */
public class StaticAccelerator implements DriveAccelerator {

	int staticAmount;

	public StaticAccelerator(int staticAmount){

		this.staticAmount = staticAmount;
	}

	@Override
	public int getAmount() {
		return staticAmount;
	}
}
