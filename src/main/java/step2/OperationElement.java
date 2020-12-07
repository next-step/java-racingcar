package step2;

public enum OperationElement {
	OPERAND, OPERATOR;

	public static OperationElement classifyClassTypeByEvenOrOdd(int index) {
		return index % 2 == 0 ? OperationElement.OPERAND : OperationElement.OPERATOR;
	}
}
