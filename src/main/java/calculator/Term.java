package calculator;

/**
 * 수식을 구성하는 "항"
 * 연산자와 값의 쌍으로 구성되며 Immutable 한 Value object
 */
public class Term {

	//-------------------------------------------------------------------------
	//
	// Properties
	//
	//-------------------------------------------------------------------------

	//---------------------------------
	// value
	//---------------------------------

	private int value;

	public int getValue(){
		return value;
	}


	//---------------------------------
	// operator
	//---------------------------------

	// 다른 Term 과 계산될 때 연산의 종류, 로직
	private Operator operator;

	public Operator getOperator(){
		return operator;
	}


	//-------------------------------------------------------------------------
	//
	// Constructors
	//
	//-------------------------------------------------------------------------

	public Term(int value) {

		this(Operator.ADD, value);
	}

	public Term(Operator operator, int value) {
		this.operator = operator;
		this.value = value;
	}


	//-------------------------------------------------------------------------
	//
	// Public methods
	//
	//-------------------------------------------------------------------------

	public Term reduce(Term otherTerm){
		return new Term(otherTerm.getOperator().operate(this.value, otherTerm.getValue()));
	}

}
