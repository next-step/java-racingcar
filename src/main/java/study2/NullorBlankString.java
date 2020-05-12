package study2;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import study2.Operator;

public class NullorBlankString {

	public void inspectString(String str) {
		if(str.equals("") || str.equals(" ")) {
			System.out.println("다시 입력해 주세요.");
		}
	}
	
	public void notOperator(String str) {
		if(str.equals(Operator.ADD) || str.equals(Operator.SUB) || str.equals(Operator.MULTI) || str.equals(Operator.DIV)) {
			
		}
	}
	
}
