package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Calculator {



    public static int cal(String data) {
        if (verifyNullOrSpace(data)) {
            return 0;
        }
        return sumWithDelimiter(splitDelimiter(checkNegative(data)));
    }

    //null 혹은 공백일 때 0 반환 메서드
    private static boolean verifyNullOrSpace(String data) {
        if (data.isBlank() || Objects.isNull(data)) {
            return true;
        }
        return false;
    }

    //형변환 메서드
    private static int verifyParseInt(String data) {
        return Integer.parseInt(data);
    }

    //구분자가 있으면 덧셈 메서드
    private static int sumWithDelimiter(String[] datas) {
        int result = 0;

        //FIXME split 하고 난 뒤의 첫 번째 빈 공백을 처리할 방법이 생각이 나지않아 임시로 지움
        String[] processedDatas = new String[datas.length - 1];
        System.arraycopy(datas, 1, processedDatas, 0, processedDatas.length);


        for (String data : processedDatas) {
            result += verifyParseInt(data);
        }
        return result;
    }

    //덧셈을 편하게 하기 위한 split 메서드
    private static String[] splitDelimiter(String data) {
        String[] result = new String[0];

        //초기화
        String delimiter = "[,:]";
        String processedData = data;

        if (data.contains("//") && data.contains("\n")) {
            delimiter = "[,:" + registerDelimiter(data) + "]";
            processedData = data.replaceAll("[//\n]","");
        }


        result = processedData.split(delimiter);



        return result;
    }

    //커스텀 구분자 등록
    private static String registerDelimiter(String data) {

        if (data.contains("//") && data.contains("\n")) {
            return String.valueOf(data.charAt((data.indexOf("//")) + 2));
        }
        return null;
    }

    private static String checkNegative(String data) {
        if (data.contains("-")) {
            throw new RuntimeException();
        }

        return data;
    }
}
