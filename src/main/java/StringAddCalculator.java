/**
 * 기능 요구사항
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
 * (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 *
 * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
 * 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 *
 * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 *
 * 프로그래밍 요구사항
 * 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
 *
 * 기능 요구사항 분리 및 힌트
 * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
 * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
 * 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
 * 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
 * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
 * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
 */
public class StringAddCalculator {
    
    public static int splitAndSum(String ogText) {
        // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
        if(ogText == null || ogText.isEmpty()) {
            return 0;
        }

        // 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
        if(ogText.startsWith("//")) {
            int indexOfSlashN = ogText.indexOf("\n");
            String delimiter = ogText.substring(2, indexOfSlashN);
            String subText = ogText.substring(indexOfSlashN + 1);
            return getResultSum(subText, delimiter);
        }

        return getResultSum(ogText, ",|:");
    }

    // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    // 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
    // 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
    private static int getResultSum(String ogText, String delimiter) {
        int resultSum = 0;
        String[] splTexts = ogText.split(delimiter);
        for(String splText : splTexts) {
            int parsedVal = getParsedVal(splText);
            resultSum += parsedVal;
        }
        return resultSum;
    }

    // 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
    private static int getParsedVal(String splText) {
        int parsedVal = Integer.parseInt(splText);
        if(parsedVal < 0) {
            throw new RuntimeException("음수가 전달되었습니다!");
        }
        return parsedVal;
    }

}
