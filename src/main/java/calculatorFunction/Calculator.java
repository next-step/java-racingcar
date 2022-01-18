package calculatorFunction;

public class Calculator {
    public int calculate(String[] stringArray){
        for(int i=0; i< (stringArray.length-1)/2; i++){
            if (stringArray[i*2+1]==null)
                return Integer.parseInt(stringArray[i*2]);    //정수로 바꿔서 리턴
            parseOperation(stringArray,i*2);
        }

        return 1;
    }

    public void parseOperation(String[] stringArray, int start){
        int firstOperand, secondOperand;
        String operator=stringArray[start+1];
        firstOperand=Integer.parseInt(stringArray[start]);
        secondOperand=Integer.parseInt(stringArray[start+2]);
        int result=0;
        if(operator.equals("+")){
            result=add(firstOperand,secondOperand);
        }
        else if(operator.equals("-")){
            result=sub(firstOperand,secondOperand);
        }
        else if(operator.equals("*")){
            result=mul(firstOperand,secondOperand);
        }
        else if(operator.equals("/")){
            result=div(firstOperand,secondOperand);
        }
        else{
            System.out.println("ERROR");
        }
        stringArray[start+2]=String.valueOf(result);
        return;
    }

    public int add(int firstOperand, int secondOperand) {

        return firstOperand + secondOperand;
    }
    public int sub(int firstOperand, int secondOperand){

        return firstOperand - secondOperand;
    }
    public int mul(int firstOperand, int secondOperand) {

        return firstOperand * secondOperand;
    }
    public int div(int firstOperand, int secondOperand) {

        return firstOperand / secondOperand;
    }
}
