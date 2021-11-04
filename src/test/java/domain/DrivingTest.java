package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DrivingTest {
	@Test
	@DisplayName("0부터 9까지 의 랜덤값 한번 생성")
	public void createRandomNumber(){
		assertThat(Driving.drive()).isBetween(0,9);
	}
}
