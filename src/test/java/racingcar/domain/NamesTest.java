package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {
	@Test
	@DisplayName("입력된 문자열을 ','로 나눠 리스트로 반환한다.")
	void getNameListTest() {
		Names names = new Names("test1,test2,test3");

		assertThat(names.getNameList())
			.isInstanceOf(List.class)
			.containsExactly("test1", "test2", "test3");
	}
}
