package calculator;

import java.util.Arrays;

public class Calculator {

    public Integer calculate(String reqString){
        String[] operArr = {"+", "-", "*", "/"};

        if(reqString == null || reqString.isEmpty()){
            throw new IllegalArgumentException();
        }
        String[] reqParts = reqString.split(" ");
        Integer result = Integer.parseInt(reqParts[0]);

        for(int i=0; i<reqParts.length; i++){
            if(!this.isParseInt(reqParts[i])){
                if(Arrays.asList(operArr).contains(reqParts[i])){
                    if(reqParts[i].equals("+")){
                        result+=Integer.parseInt(reqParts[i+1]);
                    }
                    else if(reqParts[i].equals("-")){
                        result-=Integer.parseInt(reqParts[i+1]);
                    }
                    else if(reqParts[i].equals("*")){
                        result*=Integer.parseInt(reqParts[i+1]);
                    }
                    else if(reqParts[i].equals("/")){
                        if(Integer.parseInt(reqParts[i+1]) == 0){
                            // 0으로 나눌 수 없음.
                            continue;
                        }
                        result/=Integer.parseInt(reqParts[i+1]);
                    }
                }else{
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
