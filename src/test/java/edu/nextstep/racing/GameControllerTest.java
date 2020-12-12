package edu.nextstep.racing;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.racing.domain.Car;
import edu.nextstep.racing.domain.Name;

@DisplayName("GameController : Game을 play하고 그 결과가 view로 표시될 수 있도록 하는 MVC모델의 Controller 클래스")
class GameControllerTest {

	@DisplayName("createGameCars : 자동차 이름들을 파라미터로 받아 목록길이만큼의 이름 달린 자동차들을 생성하여 리턴해야 함.")
	@Test
	void createGameCars() {
		String[] namesOfCars = new String[] {"pobi", "crong", "honux"};
		List<Car> gameCars = new GameController().createGameCars(namesOfCars);
		assertThat(gameCars).hasSize(3);
		assertThat(gameCars.get(0).getName()).isEqualTo(new Name("pobi"));
		assertThat(gameCars.get(1).getName()).isEqualTo(new Name("crong"));
		assertThat(gameCars.get(2).getName()).isEqualTo(new Name("honux"));
	}

	@DisplayName("createRacingGame : 파라미터로 넘겨준 만큼의 자동차 대수를 가지는 새 게임을 생성해 리턴해야 함")
	@Test
	void createRacingGame() {
		String[] namesOfCars = new String[] {"pobi", "crong", "honux"};
		assertThat(new GameController().createRacingGame(namesOfCars, 5))
			.isNotNull()
			.satisfies(game -> assertThat(game.getCars().getAll()).hasSize(namesOfCars.length));
	}
}