package step4.util;

import step4.domain.Data;

public class InputValidator {

    private static final int nameLength = 5;

    public static Data validate(Data data) {
        // names null check
        if(data.getNames() == null || data.getNames().length() < 1 ){
            throw new IllegalArgumentException("입력한 자동차 이름이 없습니다.");
        }

        if(data.getCount()  < 1 ){
            throw new IllegalArgumentException("입력한 숫자가 올바르지 않습니다.");
        }

        String [] names = data.spliteName(",");
        for(String name : names){
            nameCheck(name);
        }

        return data;
    }

    private static void nameCheck(String name){
        if(name.length() > nameLength){
            String message = "자동차 이름이 {0}자 초과하였습니다.".replaceAll("\\{0\\}", String.valueOf(nameLength));
            throw new IllegalArgumentException(message);
        }
    }
}
