package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("커맨드 테스트")
public class CommandTest {

	@Test
	@DisplayName("커맨드 생성 테스트")
	void createCommandTest() {
		int count = 5;
		String nameLine = "pobi,crong,honux";
		Command command = new Command(count, nameLine);

		assertThat(command).isNotNull();
		assertThat(command.getCount()).isEqualTo(count);
		assertThat(command.getNames()).isEqualTo(new String[] {"pobi", "crong", "honux"});
	}
}
