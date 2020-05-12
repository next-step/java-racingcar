package Calculator;

import java.util.Arrays;

public class StringCalculator {
    final String seperator = " "; //입력되는 inputData Seperator
    final int CALCULATE_COUNT = 2; //계산하는 대상 갯수 현재 계산기는 2개만 계산 될 수 있다.


    public double calculate(String inputData){
        //input data validate
        //입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
        if(inputData ==null || inputData.isEmpty()){
            throw new IllegalArgumentException();
        }
        String[] inputArray = inputData.split(seperator);
        //input data validate
        //입력 값이 불완전 하거나 빈 공백 문자일 경우 IllegalArgumentException throw
        if(inputArray.length<3){
            throw new IllegalArgumentException();
        }

        double result = recursive_Calculating(inputArray);

        return result;
    }

    public double recursive_Calculating(String[] inputArray) {
        //계산 되어야 하는 INPUT 값이 최종적인 값 하나 또는 둘(잘못된 데이터)로 나왔을 경우 값을 바로 반환.
        if(inputArray.length <3) {
            return Double.parseDouble(inputArray[0]);
        }

        //operator는 항상 가운데 위치(중위표현)한다.
        //OperatorEnum에서 operator의 type을 find 한다.
        OperatorEnum operator= OperatorEnum.find(inputArray[CALCULATE_COUNT-1]);
        //operator type(+,-,*,/)에 맞는 Calculator를 획득.
        Calculator calculator = operator.calculate(operator);
        //형변환때 유효하지 않은 데이터가 전달 시 처리를 위하여 try 문 처리.
        try {
            //획득한 calculator를 가지고 두 수를 계산한다.
            double result = calculator.calculator(Double.parseDouble(inputArray[CALCULATE_COUNT-2]),Double.parseDouble(inputArray[CALCULATE_COUNT]));
            inputArray[CALCULATE_COUNT] = Double.toString(result);
            //계산된 값은 버리고 계산 안된 새로운 array로 생성
            String[] _inputArray = Arrays.copyOfRange(inputArray, CALCULATE_COUNT, inputArray.length);

            //기존 배열 카피 방식에서 위 방식으로 수정....
            /*
             * String[] _inputArray = new String[inputArray.length-CALCULATE_COUNT];
             * _inputArray[0] = Double.toString(result);
             *
             * for(int i = 1; i < _inputArray.length;i++) { _inputArray[i]
             * =inputArray[i+CALCULATE_COUNT]; }
             */
            //재귀 호출 한다.
            return recursive_Calculating(_inputArray);
        }catch (NumberFormatException exception){
            return 0.0;
        }

        //계산된 값을 기존 array의 유효범위 (계산된 두 값 중 마지막 값의 인덱스, 계산된 대상) 마지막 인덱스에 치환.

    }
}
