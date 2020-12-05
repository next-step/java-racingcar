package step2;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueueUtils {
	public static <T, E> Queue<T> mapToQueue(List<E> list, Function<E, T> function) {
		if (Objects.isNull(list) || Objects.isNull(function)) {
			throw new IllegalArgumentException(
				String.format("list and function must not be null. list:[%s], function:[%s]", list, function)
			);
		}

		return list.stream()
			.map(function)
			.collect(Collectors.toCollection(ArrayDeque::new));
	}
}
