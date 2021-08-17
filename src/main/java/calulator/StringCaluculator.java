package calulator;

public class StringCaluculator {

    public int calculate(String s) {
        //"1+2"
        String[] input = s.split("");
        return Operator.find(input[1]).calculate(Integer.parseInt(input[0]), Integer.parseInt(input[2]));
    }

}
