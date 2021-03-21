package step4.util;

import step4.domain.Data;

public class InputValidator {

    private static final int nameLength = 5;

    Data data;
    public static Data validate(Data data) {
        // names null check
        if(data.getNames() == null || data.getNames().length() < 1 ){
            throw new IllegalArgumentException("입력한 자동차 이름이 없습니다.");
        }

        String [] names = data.getNames().split(",");
        for(String name : names){
            nameCheck(name);
        }

        return data;
    }

    private static void nameCheck(String name){
        if(name.length() > nameLength){
            throw new IllegalArgumentException("자동차 이름이 5자 초과하였습니다.");
        }
    }
}
