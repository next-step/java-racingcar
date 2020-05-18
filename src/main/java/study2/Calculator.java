package study2;

public class Calculator {

	CheckStringOrOpearator check = new CheckStringOrOpearator();
	Operator op = new Operator();

	public int calculate(String[] str) {
		int result = 0; // 결과 저장

		for (int i = 0; i < str.length - 1; i += 2) {
			int sum = 0;
			check.notOperator(str[i + 1]); // 연산자 check

			if (str[i + 1].equals(Operator.ADD)) {
				sum = op.add(Integer.parseInt(str[i]), Integer.parseInt(str[i + 2]));
				str[i + 2] = Integer.toString(sum);
			}

			if (str[i + 1].equals(Operator.SUB)) {
				sum = op.sub(Integer.parseInt(str[i]), Integer.parseInt(str[i + 2]));
				str[i + 2] = Integer.toString(sum);
			}

			if (str[i + 1].equals(Operator.MULTI)) {
				sum = op.multi(Integer.parseInt(str[i]), Integer.parseInt(str[i + 2]));
				str[i + 2] = Integer.toString(sum);
			}
			if (str[i + 1].equals(Operator.DIV)) {
				sum = op.divide(Integer.parseInt(str[i]), Integer.parseInt(str[i + 2]));
				str[i + 2] = Integer.toString(sum);
			}
			result = Integer.parseInt(str[i + 2]);
		}
		System.out.println("연산 결과는 :  " + result);
		return result;
	}
}
