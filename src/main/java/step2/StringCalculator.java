package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

    public int calculator(String data) {
        dataValid(data);

        String replaceData = data.replaceAll(" ", "");
        List<String> datas = IntStream.range(0, replaceData.length())
                .mapToObj(i -> String.valueOf(replaceData.charAt(i)))
                .collect(Collectors.toList());

        validate(datas);

        int value = Integer.parseInt(datas.get(0));
        for (int i = 0; i < datas.size() - 2; i += 2) {
            value = Operator.calculate(datas.get(i + 1), value, Integer.parseInt(datas.get(i + 2)));
        }

        return value;
    }

    public boolean isNumeric(String data) {
        return Pattern.compile("(^[0-9]*$)").matcher(data).matches();
    }

    public boolean isOperator(String data) {
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        return operators.contains(data);
    }

    public void validate(List<String> datas) {
        if (!this.isNumeric(datas.get(0))) {
            throw new IllegalArgumentException("첫번째 값이 유효하지 않습니다.");
        }

        if (this.isOperator(datas.get(datas.size() - 1))) {
            throw new IllegalArgumentException("유효하지 않은 연산입니다.");
        }
    }

    private void dataValid(String data) {
        if (data == null && data.equals("")) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
