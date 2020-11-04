package study;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {

    //연산자 정보 (String : 연산기호 , Operator : 연산기호에 따른 연산자 클래스)
    public Map<String, Operator> operatorMap;
    public List<Integer> numberList;         //숫자
    public List<String> operatorList;      //연산자

    //연산자 정보 초기화
    public Calculator(OperatorManager operators){
        operatorMap = operators.getOperators();

    }

    //입력한 값 확인 및 초기화
    public void init(String input){
        InputCheckor inputCheckor = new InputCheckor(input);

        Tokenizer tokenizer = new Tokenizer(input);

        //정규표현식으로 숫자만 필터링해서 값을 입력
        this.numberList = tokenizer.extractNumber();

        //정규표현식으로 연산자 기호만 필터링해서 값을 입력
        this.operatorList = tokenizer.extractOperator();

    }


    //연산 시작
    public int calculate(String input){
        init(input);

        int result=0;
        int first = this.numberList.get(0);
        int second = 0;
        for(int i=0;i<this.operatorList.size();i++){
            second = this.numberList.get(i+1);

            result = operatorMap.get(this.operatorList.get(i)).operate(first,second);
            first = result;
        }


        return result;
    }

}
