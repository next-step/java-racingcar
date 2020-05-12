package step2;

public class StringCalculator {
    
    /**
     * left와 right를 더해준다.
     * @param left : int, 더할 값
     * @param right : int, 더할 값
     * @return String, 더한 값을 반환
     */
    public String plus(int left, int right) {
        return String.valueOf(left+right);
    }
    /**
     * left에서 right를 뺀다.
     * @param left : int, 뺄셈 대상
     * @param right : int, left에서 빼줄 값
     * @return String, left에서 right를 뺀 값을 반환
     */
    public String minus(int left, int right) {
        return String.valueOf(left-right);
    }

}
