package study.step3.view;

public class ResultView {
    private static final String RESULT_MESSAGE_FIRST = "실행 결과";
    private static final String BLANK_STRING_VALUE = "";
    private static final String MOVE_CHARACTER = "-";
    private static final int START_LOCATION = 0;

    /**
     * 실행 결과 로그 출력
     */
    public void resultInitMessage(){
        System.out.println(RESULT_MESSAGE_FIRST);
    }

    /**
     * location 조회 시 차량 위치 로그 출력
     */
    public void printResult(int location){
        System.out.println(getPosition(location));
    }

    /**
     * String 요청값 로그 출력
     */
    public void printResult(String message){
        System.out.println(message);
    }

    /**
     * 차량 위치 출력
     * @return 차량 위치
     */
    private String getPosition(int location){
        String position = BLANK_STRING_VALUE;
        for(int i = START_LOCATION; i < location; i++){
            position += MOVE_CHARACTER;
        }
        return position;
    }

}
