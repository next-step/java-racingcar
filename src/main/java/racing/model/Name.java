package racing.model;

import racing.util.StringUtil;

public class Name {
    private String name;
    private static final int NAME_LIMIT = 5;

    public Name(String name) {
        if (StringUtil.isBlank(name)){
            throw new IllegalArgumentException("자동차 이름은 필수 값 입니다.");
        }

        if(isNotValidName(name)){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isNotValidName(String inputName){
        return NAME_LIMIT < inputName.length();
    }


}
