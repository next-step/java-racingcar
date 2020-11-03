package study;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {

    //연산자 정보 (String : 연산기호 , Operator : 연산기호에 따른 연산자 클래스)
    public Map<String, Operator> operatorMap;
    public List<String> numberList;         //숫자
    public List<String> operationList;      //연산자
    public List<String> otherList;          //숫자, 연산자가 아닌 값(잘못된 값)

    //연산자 정보 초기화
    public Calculator(){
        operatorMap = new HashMap<String, Operator>();
        operatorMap.put("+", new Addition());
        operatorMap.put("-", new Subtraction());
        operatorMap.put("*", new Multiplication());
        operatorMap.put("/", new Division());
    }

    //입력한 값 확인 및 초기화
    public void inputString(String input){
        InputCheckor inputCheckor = new InputCheckor();
        inputCheckor.checkEmpty(input);

        String[] inputArr = input.split(" ");

        //정규표현식으로 숫자만 필터링해서 값을 입력
        this.numberList = Arrays.stream(inputArr)
                                .filter(str ->str.matches("[0-9]"))
                                        .collect(Collectors.toList());
        //정규표현식으로 연산자 기호만 필터링해서 값을 입력
        this.operationList = Arrays.stream(inputArr)
                                .filter(str -> str.matches("[*/+-]"))
                                        .collect(Collectors.toList());
        //정규표현식으로 잘못 입력한 값을 필터링해서 값을 입력
        this.otherList = Arrays.stream(inputArr)
                                .filter(str -> str.matches("[^0-9^*-+/]"))
                                        .collect(Collectors.toList());

        //잘못 입력한 기호가 있는지 확인
        inputCheckor.checkOperator(this.otherList.size());

    }


    //연산 시작
    public int calculate(String input){
        inputString(input);
        int result=0;
        int first = Integer.parseInt(this.numberList.get(0));
        int second;
        for(int i=0;i<this.operationList.size();i++){
            second = Integer.parseInt(this.numberList.get(i+1));

            result = operatorMap.get(this.operationList.get(i)).operate(first,second);
            first = result;
        }


        return result;
    }

}
