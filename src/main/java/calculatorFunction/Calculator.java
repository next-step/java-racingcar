package calculatorFunction;

public class Calculator {
    public int calculate(String[] stringArray){
        for(int i=0; i< (stringArray.length-1)/2; i++){
            parseOperation(stringArray,i*2);
        }
        return Integer.parseInt(stringArray[stringArray.length-1]);    //정수로 바꿔서 리턴
    }

    public void parseOperation(String[] stringArray, int start){
        int firstOperand, secondOperand;
        String operator=stringArray[start+1];
        firstOperand=Integer.parseInt(stringArray[start]);
        secondOperand=Integer.parseInt(stringArray[start+2]);
        int result=0;
        System.out.println("operator:"+ operator);
        if(operator=="+"){
            result=add(firstOperand,secondOperand);
        }
        else if(operator=="-"){
            result=sub(firstOperand,secondOperand);
        }
        else if(operator=="*"){
            result=mul(firstOperand,secondOperand);
        }
        else if(operator=="/"){
            result=div(firstOperand,secondOperand);
        }
        else{
            System.out.println("ERROR");
        }
        stringArray[start+2]=String.valueOf(result);
        return;
    }

    public int add(int firstOperand, int secondOperand){
        return 1;
    }
    public int sub(int firstOperand, int secondOperand){
        return 1;
    }
    public int mul(int firstOperand, int secondOperand){
        return 1;
    }
    public int div(int firstOperand, int secondOperand){
        return 1;
    }
}
