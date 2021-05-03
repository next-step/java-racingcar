package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("커맨드 테스트")
public class CommandTest {

	@Test
	@DisplayName("커맨드 생성 테스트")
	void createCommandTest() {
		int inputMoveCount = 5;
		String inputNameLine = "pobi,crong,honux";
		Command command = new Command(inputMoveCount, inputNameLine);

		assertThat(command).isNotNull();
		assertThat(command.getMoveCount()).isEqualTo(inputMoveCount);
		assertThat(command.getNames()).isEqualTo(new String[] {"pobi", "crong", "honux"});
	}
}
