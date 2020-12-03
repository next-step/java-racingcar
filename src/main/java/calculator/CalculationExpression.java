package calculator;

public class CalculationExpression extends Calculation {
	private final CalculationFactor calculationFactor;

	public CalculationExpression(CalculationFactor calculationFactor) {
		this.calculationFactor = calculationFactor;
	}

	@Override
	protected void executeProcess() {
		NumberFactor baseNumber = calculationFactor.getNumber();
		NumberFactor targetNumber = calculationFactor.getNumber();
		OperatorFactor operator = calculationFactor.getOperator();
		calculationFactor.addBaseNumber(operator.valueOfFactor().calculate(baseNumber, targetNumber));
	}

	@Override
	protected boolean isContinueProcess() {
		return calculationFactor.isOperatorEmpty();
	}

	@Override
	public String calculationResult() {
		executeAll();
		return calculationFactor.getNumber().valueOf();
	}
}
