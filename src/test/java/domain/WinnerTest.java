package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinnerTest {

	private CarRaceGroup carRaceGroup;

	@BeforeEach
	public void setUp() {
		carRaceGroup = new CarRaceGroup(new CarNames("BMW,KIA,HONDA"), new CarPosition("0,1,2"));
	}

	@Test
	@DisplayName("가장 많이 이동한 위치값 확인")
	public void positionNumberMax(){
		assertThat(Winner.positionMax(carRaceGroup)).isEqualTo(2);
	}

	@Test
	@DisplayName("우승자 생성 확인")
	public void checkWinner(){
		assertThat(Winner.winnerName(carRaceGroup)).isEqualTo("HONDA");
	}
}
