package racing.model.service;

public class ForwardCarConditional implements CarConditional {

	/**
	 * Test 를 위한 CarConditional 자동차 움직임 전략
	 * @return true : 항상 앞으로 전진하는 움직임 전략
	 */
	@Override
	public boolean isMove() {
		return true;
	}
}
