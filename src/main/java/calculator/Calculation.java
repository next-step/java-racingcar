package calculator;

public abstract class Calculation {
	void executeAll() {
		if (isContinueProcess()) {
			return;
		}
		executeProcess();
		executeAll();
	}

	protected abstract boolean isContinueProcess();

	protected abstract void executeProcess();

	public abstract String calculationResult();
}
