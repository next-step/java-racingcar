package calculator;

import java.util.Arrays;

public class Calculator {

    public Integer calculate(String reqString){
        OperatorEnum[] operArr = {OperatorEnum.PLUS,
                OperatorEnum.MINUS,
                OperatorEnum.MULTIPLY,
                OperatorEnum.DIVIDE};

        if(reqString == null || reqString.isEmpty()){
            throw new IllegalArgumentException();
        }
        String[] reqParts = reqString.split(" ");
        Integer result = Integer.parseInt(reqParts[0]);

        for(int i=0; i<reqParts.length; i++){
            if(!this.isParseInt(reqParts[i])){
                switch (OperatorEnum.getOperation(reqParts[i])){
                    case PLUS:
                        result+=Integer.parseInt(reqParts[i+1]);
                        break;
                    case MINUS:
                        result-=Integer.parseInt(reqParts[i+1]);
                        break;
                    case MULTIPLY:
                        result*=Integer.parseInt(reqParts[i+1]);
                        break;
                    case DIVIDE:
                        if(Integer.parseInt(reqParts[i+1]) == 0){
                            // 0으로 나눌 수 없음.
                            continue;
                        }
                        result/=Integer.parseInt(reqParts[i+1]);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return result;
    }

    public boolean isParseInt(String reqString){
        try{
            Integer.parseInt(reqString);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
