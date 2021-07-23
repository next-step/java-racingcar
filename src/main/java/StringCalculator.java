
public class StringCalculator {
    public int calculate(String s) {
        if(s == null) throw new IllegalArgumentException("null값을 입력받았습니다.");
        String[] splitedString = s.split(" ");
        if(splitedString.length == 0) throw new IllegalArgumentException("빈값을 입력받았습니다.");
        int output = Integer.parseInt(splitedString[0]);
        if(splitedString.length == 1) return output;
        int size = splitedString.length;
        for(int i=1;i<size;i+=2){
            if(i+1 == size) throw new IllegalArgumentException("숫자가 부족합니다.");
            int rightNum = 0;
            try {
                rightNum = Integer.parseInt(splitedString[i+1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 수를 입력받았습니다.");
            }
            if(splitedString[i].equals("+")) {
                output += rightNum;
            }
        }

        return output;
    }


}
