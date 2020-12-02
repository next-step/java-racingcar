package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.view.InputView;
import racing.view.ResultView;

import javax.xml.transform.Result;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

	InputView inputView = new InputView();
	ResultView resultView = new ResultView();

	RacingCar racingCar = new RacingCar();

	@BeforeEach
	void setUp() {
		inputView.setPlayCarCount(3);
		inputView.setPlayCount(5);
	}

	@Test
	@DisplayName("자동차 경주 테스트")
	void testRacing() {
		racingCar.playRacingCar(inputView.getPlayCarCount(), inputView.getPlayCount(), resultView);
	}

}