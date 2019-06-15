package calculator;

public enum Operator {
	ADD("+", (int a, int b) ->  a + b),
	DIFFERENCE("-", (int a, int b) ->  a - b),
	MULTIPLY("*", (int a, int b) ->  a * b),
	DIVISION("/", (int a, int b) ->  a / b);

	String sign;

	OperationFunc func;

	/**
	 * 연산자 Enum 생성자, 연산의 종류가 정해지면 그 로직도 결정되기 때문에 함께 정의
	 * @param sign 연산자 부호
	 * @param func 연산수행 로직
	 */
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
