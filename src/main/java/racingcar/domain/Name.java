package racingcar.domain;

import racingcar.common.utils.TextLimitSizeValidator;

public class Name {

    private static final int TEXT_LENGTH_LIMIT = 5;
    private final String text;

    public Name(String text){
        if(isEmptyOrNull(text)){
            throw new IllegalArgumentException("한 글자 이상의 이름을 입력해주세요.");
        }
        this.text = text;
        errorIfTextLengthLimitOver();
    }

    private void errorIfTextLengthLimitOver(){
        if (TextLimitSizeValidator.isOverLimitSize(this.text, TEXT_LENGTH_LIMIT)){
            throw new IllegalArgumentException("자동차 이름은" + TEXT_LENGTH_LIMIT + "자 이상만 입력 가능합니다.");
        }
    }

    private boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

    public String getText(){
        return this.text;
    }

}
