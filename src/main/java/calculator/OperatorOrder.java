package calculator;


/**
 * 문자열 중에서 연산자가 존재하는 index와 해당되는 문자열 저장하는 객체
 */
public class OperatorOrder {

    char operatorText; // 연산자
    int index;  // 연산자가 존재하는 inex

    public char getOperatorText() {
        return operatorText;
    }

    public void setOperatorText(char operatorText) {
        this.operatorText = operatorText;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
