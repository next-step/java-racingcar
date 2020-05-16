package study2;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import study2.Operator;

public class CheckStringOrOpearator {

	// 공백이거나 null check
	public void inspectNullCheck(String str) {
		if(str.equals("") || str.equals(" ")) {
			throw new IllegalArgumentException("공백이나 null입니다");
		}
	}
	
	public void notOperator(String str) {
		if( !(str.equals(Operator.ADD))) {
			return;
		}
		if (!(str.equals(Operator.SUB))) {
			return;
		}
		if (!(str.equals(Operator.MULTI))) {
			return;
		}
		if (!(str.equals(Operator.DIV))) { 
			return;
		}
		throw new IllegalArgumentException("연산자를 확인하세요");
	}
	
	public void allOperatorIncludeCheck(String str) {
		if(!(str.contains(Operator.ADD)) 
				|| !(str.contains(Operator.SUB))
				|| !(str.contains(Operator.MULTI))
				|| !(str.contains(Operator.DIV))) {
			throw new IllegalArgumentException("모든 연산자를 포함하세요");
	}
	
}
}