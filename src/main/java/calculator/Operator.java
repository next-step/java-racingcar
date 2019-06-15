package calculator;

public enum Operator {
	ADD("+", (int a, int b) ->  a + b),
	DIFFERENCE("-", (int a, int b) ->  a - b),
	MULTIPLY("*", (int a, int b) ->  a * b),
	DIVISION("/", (int a, int b) ->  a / b);

	String sign;

	OperationFunc func;

	Operator(String sign, OperationFunc func){
		this.sign = sign;
		this.func = func;
	}

	public int operate(int a, int b){
		return func.execute(a, b);
	}

	public static Operator valueOfSign(String sign){
		for(Operator o : Operator.values()){
			if(o.sign.equals(sign)){
				return o;
			}
		}

		throw new IllegalArgumentException();
	}
}
