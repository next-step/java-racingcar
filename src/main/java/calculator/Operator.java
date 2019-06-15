package calculator;

public enum Operator {
	ADD("+"),
	DIFFERENCE("-"),
	MULTIPLY("*");

	String sign;

	Operator(String sign){
		this.sign = sign;
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
