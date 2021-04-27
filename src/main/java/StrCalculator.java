import java.util.ArrayList;
import java.util.Arrays;

public class StrCalculator {
    String sum(String a, String b) {
        int intA = Integer.parseInt(a), intB = Integer.parseInt(b);
        int result = intA + intB;

        return Integer.toString(result);
    }

    String sub(String a, String b) {
        int intA = Integer.parseInt(a), intB = Integer.parseInt(b);
        int result = intA - intB;

        return Integer.toString(result);
    }

    String multi(String a, String b) {
        int intA = Integer.parseInt(a), intB = Integer.parseInt(b);
        int result = intA * intB;

        return Integer.toString(result);
    }

    String div(String a, String b) {
        int intA = Integer.parseInt(a), intB = Integer.parseInt(b);

        if (intB == 0) {
            throw new IllegalArgumentException("Divided by 0.");
        }
        int result = intA / intB;

        return Integer.toString(result);
    }

    void checkOperation(String oper) {
        if (oper == null || oper.isEmpty()) {
            throw new IllegalArgumentException("Operation is empty");
        }
    }

    ArrayList<String> splitOper(String oper) {
        String[] temp = oper.split(" ");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(temp));
        return list;
    }

    ArrayList<String> separation(ArrayList<String> list) {
        ArrayList<String> subList = new ArrayList<String>(list.subList(0, 3));

        for(int i = 0; i < 3; i++) {
            list.remove(0);
        }
        return subList;
    }

    String calOneByOne(ArrayList<String> subList) {
        String result;

        if(subList.get(1) == "+") {
            result = sum(subList.get(0), subList.get(2));
        }
        else if(subList.get(1) == "-") {
            result = sub(subList.get(0), subList.get(2));
        }
        else if(subList.get(1) == "*") {
            result = multi(subList.get(0), subList.get(2));
        }
        else if(subList.get(1) == "/") {
            result = div(subList.get(0), subList.get(2));
        }
        else {
            throw new IllegalArgumentException("Not the four fundamental arithmetic.");
        }

        return  result;
    }

    void combineList(String[] operList, String result) {

    }

    /*String calculate(String oper) {
        checkOperation(oper);

        String[] operList = splitOper(oper);

        for(int i = 0; i < operList.length;  i++){
    }*/

}
