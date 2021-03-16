package step4.util;

public enum MsgConstants {
  INPUT_REQUIRE_CAR("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
  INPUT_REQUIRE_ATTEMPT("시도할 회수는 몇 회 인가요?"),
  INPUT_ERROR_ATTEMPTS("입력된 경주 횟수를 확인하세요."),
  INPUT_ERROR_CAR_NAMES("입력된 차량들의 이름을 확인하세요. 1~5자 허용입니다."),
  INPUT_ERROR_CAR_FULL_NAMES("입력된 차량들의 전체 이름이 잘못 되었습니다."),
  RESULT_PRINT_PRE_RUN("실행 결과"),
  RESULT_PRINT_AFTER_RUN("가 최종 우승했습니다.")
  ;

  private final String msg;

  MsgConstants(String msg){
    this.msg = msg;
  }

  public String getMessage(){
    return msg;
  }
}
