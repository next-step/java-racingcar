package racing.enums;

import racing.exception.RacingQuestionKeywordException;

public enum RacingQuestionEnum {

    CAR("car", "자동차 대수는 몇 대 인가요?"),
    ATTEMPT("attempt", "시도할 회수는 몇 회 인가요?");

    private final String keyword;
    private final String question;

    RacingQuestionEnum(String keyword, String question) {
        this.keyword = keyword;
        this.question = question;
    }

    public static String getQuestionByKeyword(String keyword) {
        for (RacingQuestionEnum util : values()) {
            if (util.keyword.equals(keyword)) {
                return util.question;
            }
        }

        throw new RacingQuestionKeywordException("Invalid keyword: " + keyword);
    }
}
