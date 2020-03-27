package step2;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    protected static final String ERROR_MESSAGE = "잘못된 값을 입력하였습니다. 입력값을 확인해주세요.";
    protected static final String UNSUPPORTED_OPERATOR_ERROR_MESSAGE = "사용할 수 없는 연산자 입니다. 입력값을 확인해주세요.";

    private final String DELIMITER = " ";

    public int perform(String param) {
        List<String> params = parsing(param);
        int result = 0;
        for (int i = 0; i < params.size(); i += 2) {
            if (i == 0) {
                result += Integer.parseInt(params.get(i));
                continue;
            }

            switch (params.get(i-1)) {
                case "+":
                    result = add(result, Integer.parseInt(params.get(i)));
                    break;
                case "-":
                    result = subtract(result, Integer.parseInt(params.get(i)));
                    break;
                case "*":
                    result = multiply(result, Integer.parseInt(params.get(i)));
                    break;
                case "/":
                    result = divide(result, Integer.parseInt(params.get(i)));
                    break;
                default:
                    throw new IllegalArgumentException(UNSUPPORTED_OPERATOR_ERROR_MESSAGE);
            }
        }

        return result;
    }

    private List<String> parsing(String param) {
        if (param == null || param.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        List<String> result = Arrays.asList(param.split(DELIMITER));
        if (result.size() == 1 || result.size() % 2 == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        try {
            for (int i = 0; i < result.size(); i += 2) {
                Integer.parseInt(result.get(i));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return result;
    }

    private int add(int args1, int args2) {
        return args1 + args2;
    }

    private int subtract(int args1, int args2) {
        return args1 - args2;
    }

    private int multiply(int args1, int args2) {
        return args1 * args2;
    }

    private int divide(int args1, int args2) {
        return args1 / args2;
    }
}
