package racingcar.utils;

public class Utils {
    public static String[] nameAnalysis(String input){
        String[] names = input.split(",");
        for(String name : names){
            if(name.trim().isEmpty() || name.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return names;
    }

    public static int tryAnalysis(String input){
        try {
            int tryCnt = Integer.parseInt(input);
            if (tryCnt < 1) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상으로 입력해야합니다.");
            }
            return tryCnt;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("유효한 입력을 해야합니다.");
        }
    }
}
