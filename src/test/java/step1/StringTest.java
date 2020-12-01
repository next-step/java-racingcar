package step1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author : byungkyu
 * @date : 2020/11/30
 * @description : String 클래스에 대한 학습 테스트
 **/
@TestMethodOrder(OrderAnnotation.class)
class StringTest {

	@Order(1)
	@DisplayName("1.1. \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
	@Test
	void split_two_value_is_correct() {
		String arg = "1,2";
		String[] splitValue = arg.split(",");
		assertThat(splitValue.length).isEqualTo(2);
		assertThat(splitValue).contains("1", "2");
	}

	@Order(2)
	@DisplayName("1.2. \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
	@Test
	void split_one_value_with_comma_is_correct() {
		String arg = "1,";
		String[] splitValue = arg.split(",");
		assertThat(splitValue.length).isEqualTo(1);
		assertThat(splitValue).containsExactly("1");
	}

	@Order(3)
	@DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
	@Test
	void split_values_is_correct() {
		String arg = "(1,2)";
		String[] splitValue = arg.substring(arg.indexOf("(") + 1, arg.indexOf(")")).split(",");
		assertThat(splitValue.length).isEqualTo(2);
		assertThat(splitValue).contains("1", "2");
	}
}
