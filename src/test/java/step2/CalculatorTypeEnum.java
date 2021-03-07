package step2;

public enum CalculatorTypeEnum {
	PLUS ("+") {
		@Override
		public int calculate(int value1, int value2) {
			return value1 + value2;
		}
	}, 
	MINUS ("-") {
		@Override
		public int calculate(int value1, int value2) {
			return value1 - value2;
		}
	},
	MULTIPLY ("*") {
		@Override
		public int calculate(int value1, int value2) {
			return value1 * value2;
		}
	},
	DEVIDE ("/") {
		@Override
		public int calculate(int value1, int value2) {
			return value1 / value2;
		}
	};
	
	private String sign;
	
	CalculatorTypeEnum (String sign) {
		this.sign = sign;
	}
	
	public abstract int calculate(int value1, int value2);
	
	public String getSign() {
		return sign;
	}
	
	public static CalculatorTypeEnum getCalculatorBySign(String sign) {
		for( CalculatorTypeEnum ce : CalculatorTypeEnum.values() ) {
			if( ce.getSign().equals(sign) ) {
				return ce;
			}
		}
		return null;
	}
	
}
