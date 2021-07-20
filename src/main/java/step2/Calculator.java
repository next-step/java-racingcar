package step2;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class Calculator {

    public static final int minimumSize = 2;
    public static final int endCalculateSize = 1;
    private Deque<String> express;

    public Calculator(String s) {
        this.splitData(s);
    }

    private void splitData(String s) {
        if(isNullOrBlank(s)){
            throw new IllegalArgumentException("입력 문자 공백 or null 에러");
        }
        String[] lines = s.split(" ");
        this.saveData(lines);
    }

    private boolean isNullOrBlank(String s) {
        return s == null || s.trim().isEmpty();
    }


    private void saveData(String[] lines) {
        express = new LinkedList<String>(Arrays.asList(lines));
    }

    public int calculate(){

        isCollectSyntax(express);

        while(express.size() > minimumSize){

            Integer num1 = Integer.valueOf(express.poll());
            Operation operator = Operation.of(express.poll());
            Integer num2 = Integer.valueOf(express.poll());

            express.addFirst(String.valueOf(operator.calculate(num1,num2)));
        }

        if(express.size() == endCalculateSize){
            return Integer.valueOf(express.getFirst());
        }

        return 0;
    }

    public void isCollectSyntax(Deque express){
        if(express.size() < minimumSize || evenSize(express)){
            throw new IllegalArgumentException("잘못된 수식");
        }
    }

    private boolean evenSize(Deque express) {
        return express.size() % 2 == 0;
    }

    public Deque<String> getExpress() {
        return express;
    }
}
