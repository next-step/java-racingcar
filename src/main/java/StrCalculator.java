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

    String[] splitOper(String oper) {
        return oper.split(" ");
    }

    String[] separation(String[] list) {
        return Arrays.copyOfRange(list, 0, 3);
    }

    String calOneByOne(String[] subList) {
        String result;

        if(subList[1] == "+") {
            result = sum(subList[0], subList[2]);
        }
        else if(subList[1] == "-") {
            result = sub(subList[0], subList[2]);
        }
        else if(subList[1] == "*") {
            result = multi(subList[0], subList[2]);
        }
        else if(subList[1] == "/") {
            result = div(subList[0], subList[2]);
        }
        else {
            throw new IllegalArgumentException("Not the four fundamental arithmetic.");
        }

        return  result;
    }

    /*String calculate(String oper) {
        checkExpression(oper);
    }*/

}
