package racinggame.domain;

import org.junit.Test;
import racinggame.domain.car.CarDTO;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 04/11/2018.
 */
public class RacingGameResultTest {

	@Test
	public void test_현재_상위랭커_리스트_1등() {
		List<CarDTO> carDTOList = Arrays.asList(
			new CarDTO("1", 5),
			new CarDTO("2", 1),
			new CarDTO("3", 2));

		RacingGameResult racingGameResult = new RacingGameResult(carDTOList);

		int maxPosition = racingGameResult.getMaxPosition();
		List<CarDTO> topRankingCarDTOList = racingGameResult.getTopRankingCarDTOList();
		assertThat(maxPosition).isEqualTo(5);
		assertThat(topRankingCarDTOList).hasSize(1);
		assertThat(topRankingCarDTOList).extracting("name").contains("1");
		assertThat(topRankingCarDTOList).extracting("position").contains(maxPosition);
	}

	@Test
	public void test_현재_상위랭커_리스트_공동1등() {
		List<CarDTO> carDTOList = Arrays.asList(
			new CarDTO("1", 5),
			new CarDTO("2", 1),
			new CarDTO("3", 5));

		RacingGameResult racingGameResult = new RacingGameResult(carDTOList);

		int maxPosition = racingGameResult.getMaxPosition();
		List<CarDTO> topRankingCarDTOList = racingGameResult.getTopRankingCarDTOList();
		assertThat(maxPosition).isEqualTo(5);
		assertThat(topRankingCarDTOList).hasSize(2);
		assertThat(topRankingCarDTOList).extracting("name").contains("1", "3");
		assertThat(topRankingCarDTOList).extracting("position").contains(maxPosition, maxPosition);
	}

}