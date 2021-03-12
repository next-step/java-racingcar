package racing.model;

import java.util.Arrays;

public class CarNameParser {

    private final String participationList;

    public CarNameParser(String participationList) {
        this.participationList = participationList;
    }

    /**
     * 입력받은 자동차 이름들을 분할해주는 메서드
     */
    public String[] parse() {
        String[] racingCarNames = participationList.split(",");
        boolean duplicated = Arrays.stream(racingCarNames)
                .distinct()
                .count() == racingCarNames.length;
        if (!duplicated) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
        return racingCarNames;
    }


}
