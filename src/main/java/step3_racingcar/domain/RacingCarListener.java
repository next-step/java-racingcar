package step3_racingcar.domain;

public class RacingCarListener implements Car.carStatusListener{
	@Override
	public void move() {
		System.out.println("출발");
	}

	@Override
	public void stop() {
		System.out.println("멈춤");
	}

	@Override
	public void status() {
		System.out.println("상태창");
	}
}
