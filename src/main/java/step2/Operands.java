package step2;

import java.util.List;
import java.util.Queue;

public class Operands {
	private final Queue<Operand> operands;

	private Operands(Queue<Operand> operands) {
		this.operands = operands;
	}

	public static Operands create(List<String> operands) {
		return new Operands(QueueUtils.mapToQueue(operands, Operand::create));
	}

	public Operand poll() {
		if (operands.isEmpty()) {
			return null;
		}

		return operands.poll();
	}
}
