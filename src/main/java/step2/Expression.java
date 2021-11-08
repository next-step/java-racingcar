package step2;

import java.util.LinkedList;
import java.util.List;

public class Expression {

    private List<MyNumber> numbers = new LinkedList<>();
    private List<String> operators = new LinkedList<>();

    //생성자
    public Expression(String s) {
        validate(s);

        String[] info = s.split(" ");
        for (int i = 0; i < info.length; i++) {
            init(info, i);
        }
    }

    private void validate(String s) {
        if (s == null || s.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void init(String[] info, int index) {
        if (index % 2 == 0) {
            numbers.add(new MyNumber(info[index]));
        }
        if (index % 2 == 1) {
            operators.add(info[index]);
        }
    }

    //비즈니스 메서드
    public boolean canCalculate() {
        return !numbers.isEmpty() && !operators.isEmpty();
    }

    public MyNumber nextInt() {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return numbers.remove(0);
    }

    public String nextOperator() {
        if (operators.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return operators.remove(0);
    }
}
