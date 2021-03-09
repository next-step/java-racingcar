package racing.model;

public class CarNameParser {

    private final String participationList;

    public CarNameParser(String participationList) {
        this.participationList = participationList;
    }

    /**
     * 입력받은 자동차 이름들을 분할해주는 메서드
     */
    public String[] parse() {
        return this.participationList.split(",");
    }


}
