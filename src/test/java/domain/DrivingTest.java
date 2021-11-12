package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DrivingTest {
	@Test
	@DisplayName("0부터 9까지 의 랜덤값 한번 생성")
	public void createRandomNumber() {
		assertThat(Driving.createRandomNumber()).isBetween(0, 9);
	}

	@Test
	@DisplayName("랜덤값이 0 ~ 3이면 0, 4 ~ 9이면 1 이 생성된다.")
	public void checkMoveNumber(){
		assertThat(Driving.driving()).isBetween(0, 1);
	}
}
