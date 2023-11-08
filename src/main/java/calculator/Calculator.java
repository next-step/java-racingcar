package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String tokens = ",|:";


    public static int cal(String data) {
        if (verifyNullOrSpace(data)) {
            return 0;
        }
        return sumWithDelimiter(stringToInt(splitDelimiter(data)));
    }

    //null 혹은 공백일 때 0 반환 메서드
    private static boolean verifyNullOrSpace(String data) {
        if (data == null) {
            return true;
        }
        if (data.isEmpty()) {
            return true;
        }
        return false;
    }

    //형변환 메서드
//    private static int stringToInt(String data) {
//        return Integer.parseInt(data);
//    }

    private static int[] stringToInt(String[] datas) {
        return Arrays.stream(datas)
                .mapToInt(Integer::parseInt) // 각 문자열을 정수로 변환
                .toArray();
    }

    //구분자가 있으면 덧셈 메서드
    private static int sumWithDelimiter(int[] datas) {
        int result = 0;

        for (int data : datas) {
            checkNegative(data);
            result += data;
        }
        return result;
    }

    //덧셈을 편하게 하기 위한 split 메서드
    private static String[] splitDelimiter(String data) {

        //초기화
        String processedData = data;
        String delimiter = tokens;

        if (data.contains("//") && data.contains("\n")) {
            delimiter = tokens + "|" + registerDelimiter(data);
            processedData = data.replaceAll("[//\n]","");
        }

        return removeFirstString(processedData.split(delimiter));
    }

    //커스텀 구분자 등록
    private static String registerDelimiter(String data) {

        Matcher pattern = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (pattern.find()) {
            return pattern.group(1);
        }
        return null;
    }

    //음수체크
    private static int checkNegative(int data) {
        if (data < 0) {
            throw new RuntimeException();
        }
        return data;
    }

    //String배열 첫 번째 빈칸 버리기
    private static String[] removeFirstString(String[] datas) {
        String[] processedDatas = datas;
        if (datas[0].isEmpty()) {
            //FIXME split 하고 난 뒤의 첫 번째 빈 공백을 처리할 방법이 생각이 나지않아 임시로 지움
            processedDatas = new String[datas.length - 1];
            System.arraycopy(datas, 1, processedDatas, 0, processedDatas.length);
        }
        return processedDatas;
    }
}
