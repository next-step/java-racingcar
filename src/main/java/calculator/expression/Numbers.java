package calculator.expression;

import java.util.List;

public class Numbers {
	private int index;
	private List<Integer> numbers;

	public Numbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public boolean hasNext() {
		return index < numbers.size();
	}

	public int getNext() {
		if (!hasNext()) {
			return 0;
		}

		return numbers.get(index++);
	}
}
