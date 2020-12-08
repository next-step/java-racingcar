# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항 (기능목록)
* Distance (이동 거리)
  * 0 ~ 9 의 숫자를 랜덤 생성
  * 4이상인 경우 1칸 전진
  * 4미만인 경우 정지
* 자동차
  * 현재 위치 (Distance)
    * 해당 턴 신호(메시지)를 받으면 해당 객체에게 전진 요청
* 자동차 게임 (컨트롤러)
  * 게임에 참여할 자동차 대수를 입력 받음 (UI를 통해)
    * 입력 만큼 자동차 인스턴스 생성
  * 각 자동차를 전진 시도할 횟수(턴)를 입력 받음 (UI를 통해)
    * 각 자동차에게 이동 명령
  * 모든 자동차들의 이동 수를 출력 (UI를 통해)
* OutputView (ResultView)
  * "자동차 대수는 몇 대 인가요?" 문구 출력
  * "시도할 회수는 몇 회 인가요?" 문구 출력
  * "실행 결과" 문구 출력
* InputView
  * ``` new Scanner(System.in); ``` 사용
  * 게임에 참여할 자동차 대수를 입력 받음
  * 각 자동차를 전진 시도할 횟수(턴)를 입력 받음
* 기타
  * 경우에 따라서 DTO 객체 사용할 것

## 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현. 단, UI(System.out, System.in) 로직 제외
  * 핵심 로직을 구현하는 코드와 UI 담당 로직 구분
  * UI를 InputView, ResultView와 같은 클래스를 추가해 분리
* 자바 코드 컨벤션을 지키면서 프로그래밍
  * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
  * else 예약어 사용 금지
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현, else를 사용하지 않을 수 있음
    * switch/case 사용 금지

## 기능 목록 및 commit 로그 요구사항
* feat (feature)
  * 새 기능 추가
* fix (bug fix)
  * 버그 수정
* docs (documentation)
  * 문서 작성 및 수정
* style (formatting, missing semi colons, …)
  * 오탈자 및 기타 코드 형식 수정 (기능 코드 변경이 없는 경우)
* refactor
  * 코드 리팩터링 (클린코드)
* test (when adding missing tests)
  * 테스트 코드 추가 (테스트 작성을 하지 않은 경우)
* chore (maintain)
  * 빌드 업무 및 패키지 매니저 등 수정
