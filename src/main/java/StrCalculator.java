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

        if(subList.get(1).equals("+")) {
            result = sum(subList.get(0), subList.get(2));
        }
        else if(subList.get(1).equals("-")) {
            result = sub(subList.get(0), subList.get(2));
        }
        else if(subList.get(1).equals("*")) {
            result = multi(subList.get(0), subList.get(2));
        }
        else if(subList.get(1).equals("/")) {
            result = div(subList.get(0), subList.get(2));
        }
        else {
            throw new IllegalArgumentException("Not the four fundamental arithmetic.");
        }

        return  result;
    }

    void combineList(ArrayList<String> operList, String result) {
        operList.add(0, result);
    }

    String calculate(String oper) {
        checkOperation(oper);

        ArrayList<String> operList = splitOper(oper);

        while(operList.size() >= 3) {
            ArrayList<String> subList = separation(operList);
            String result = calOneByOne(subList);
            combineList(operList, result);
        }

        return operList.get(0);
    }

}
