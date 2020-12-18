package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueUtilsTest {
	@Test
	@DisplayName("list가 null이면 IllegalArgumentExcpetion이 발생한다.")
	void mapToQueue_ThrowIllegalArgumentExceptionWhenListIsNull() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> QueueUtils.mapToQueue(null, Operand::create));
	}

	@Test
	@DisplayName("function이 null이면 IllegalArgumentExcpetion이 발생한다.")
	void mapToQueue_ThrowIllegalArgumentExceptionWhenFunctionIsNull() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> QueueUtils.mapToQueue(Arrays.asList("a", "b", "c"), null));
	}

	@Test
	@DisplayName("list를 function에 넣어 나온 결과값으로 queue를 생성한다.")
	void mapToQueueTest() {
		assertThat(QueueUtils.mapToQueue(Arrays.asList("1", "2", "2"), Integer::parseInt))
			.isInstanceOf(Queue.class)
			.containsExactly(1, 2, 2);
	}

}