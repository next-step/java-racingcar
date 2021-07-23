public class StringCalculator {
    public int calculate(String s) {
        if(s == null) throw new IllegalArgumentException("null값을 입력받았습니다.");
        String[] splitedString = s.split(" ");
        if(splitedString.length == 0) throw new IllegalArgumentException("빈값을 입력받았습니다.");
        if(splitedString.length == 1) return Integer.parseInt(s);
        return Integer.parseInt(splitedString[0]) + Integer.parseInt(splitedString[2]);
    }
}
