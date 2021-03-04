package calculator;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Calculator {

    public Calculator() { }

    public int calculate(String express){
        if(isBlank(express)) throw new IllegalArgumentException();
        String[] data = express.split(" ");
        int sum =  0;
        for(int i=0; i < data.length-2; i+=2){
            if(!isPlus(data[i+1])) throw new IllegalArgumentException();
            sum += (Integer.parseInt(data[i]) + Integer.parseInt(data[i+2]));
        }
        return sum;
    }

    private boolean isBlank(String express){
        if(express.equals(" ") || express.contains("  ") || express == null) return true;
        return false;
    }

    private boolean isPlus(String operation){
        if(operation.equals("+")) return true;
        return false;
    }

}
