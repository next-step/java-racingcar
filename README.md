## 📌 문자열 계산기 구현할 기능 목록
- 덧셈
- 뺄셈
- 곱셈
- 나눗셈
- 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- 사칙 연산을 모두 포함하는 기능 구현

## 📌 자동차 경주 게임 구현할 기능 목록
- (Application) 자동차 이름 쉼표 기준으로 구분하기
- (CarValidator) 자동차 이름 5자 이내인지 확인하기(CarValidator 클래스 추가)
- (Car) position 업데이트 기능
- (Car) position 반환 기능
- (Application) Game 객체로 게임 동작 관리하기
- (Application) 사용자로부터 이동시킬 횟수 입력받기
- (Game) Game 을 입력한 횟수만큼 동작시키기
- (Car) name 반환 기능
- (Game) 0~9 사이 랜덤값을 통해 자동차 이동 여부 처리하기
- (Game, Car) 매 회 마다 자동차 이름과 함께 position 출력시키기
- (Game) 최종 우승자 출력시 단독, 공동 우승자 구분하여 출력하기
- 예외 상황에 대한 에러문구 출력하기
    - 자동차 이름은 5자 이내로 입력하기
    - 시도 횟수는 숫자로 입력하기
    - 자동차 이름이 중복되지 않도록 입력하기
- (GameManager) GameManager 로 게임에 대한 관리 책임 이전

## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)