# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step2. 문자열 계산기
### 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### Todo List
- 입력값 파싱
    - [X] 입력값 유효성 검증(null, 빈 문자열 금지)
    - [X] 공백을 구분자로 입력값 구분 후 리스트 반환
    - [X] parse 수행 전 무조건 유효성 검증 수행하도록 구현
- 숫자
    - [X] String을 인자로 받아서 Int 타입으로 전환
    - [X] Int 타입 변경 불가능한 인자 예외 처리 (내장 parsetInt 정적 메소드가 알아서 처리해줌)
    - [X] 같은 타입의 객체와 덧셈 기능 지원
    - [X] 같은 타입의 객체와 뺄셈 기능 지원
    - [X] 같은 타입의 객체와 곱셈 기능 지원
    - [X] 같은 타입의 객체와 나눗셈 기능 지원
    - [X] 0으로 나누는 경우 에러 처리
- 사칙연산 구분
    - [X] 사칙연산 enum 생성
    - [X] 별도 클래스에서 사칙연산 구분 후 반환
- 계산기
    - [X] 단항 연산에 대한 사칙 연산 수행
    - [X] 다항 연산에 대한 사칙 연산 수행
    - [X] String 연산자에 따라 알맞는 Operator 고르는 책임을 위임
- OperatorSelector
    - [X] 입력된 String 연산자에 따라 알맞는 Operator 반환
    - [X] 연산자 외의 문자열 입력 시 IllegalArgument 예외 발생
- Operator
    - [X] 사칙연산을 enum 타입으로 분리
    - [X] Operator enum에서 동작을 모두 갖도록 덧셈 구현
    - [X] 같은 방식으로뺄셈, 나눗셈, 곱셈 구현
- 리뷰 반영(enum 활용도 높이기)
    - [X] Number 객체의 계산 책임을 모두 Operator enum으로 이관
    - [X] OperatorSelector 객체의 책임도 Operator enum으로 이관
    - [X] Runner 클래스에서 OperatorSelector 대신 Operator enum으로 책임 이관
- 리뷰 반영(String까지 enum화 시키기)
    - [X] Operator enum에 String operator 속성 추가
    - [X] Operator select 함수 if 걷어내기

## Step3. 자동차 경주
### 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 제약조건
- else를 쓰지 않는다.
- UI를 제외한 모든 영역에 단위 테스트를 작성한다.

### Todo
- 입력
    - [X] 경주 할 자동차의 수를 입력받는다.
    - [X] 경기를 치를 횟수를 입력받는다.
- 출력
    - [X] 각 단계 별로 얼마나 움직였는지 보여준다.
    - [X] 매 단계마다 모든 차량이 얼마나 움직였는지 보여준다.
- 차량
    - [X] 차량은 움직인 거리를 속성으로 갖고 있다.
    - [X] 처음 생성된 차량은 움직인 거리가 0이다.
    - [X] 차량은 한 번 움직이면 움직인 거리를 1 증가시킨다.
    - [X] 차량은 4 이상의 값을 받을 때만 움직일 수 있다.
    - [X] int moveLength를 값 객체로 대체
    - [X] 움직일 때 파워를 주입받아야 함
    - [X] move interface 추출
    - [X] 강제로 움직이는 가짜 차량 구현
    - [X] Car interface에서 Power 주입 삭제
- 차량 일급 콜렉션
    - [X] 여러대의 차량을 입력받아 생성
    - [X] 입력된 차량 List는 변경 불가능 + 사이드 이펙트 없음
    - [X] 콜렉션 내부의 모든 차량을 한번에 움직일 수 있음
    - [X] 콜렉션 내부의 모든 차량의 움직인 거리를 보여줄 수 있음
- 차량 움직임 전략
    - [X] 4 이상의 값이 입력됐는지 여부를 판단
- 움직인 거리
    - [X] 패키지 외부에서는 값이 0인 상태로 생성 가능해야 함
    - [X] 패키지 내부에서는 값을 입력받아서 생성 가능해야 함
    - [X] 0 미만의 값으로는 생성할 수 없음
    - [X] int로 출력을 전환할 수 있어야 함
    - [X] 1씩 증가시킬 수 있어야 함
    - [X] 동등 비교가 가능해야 함
    - [X] boolean isMoveable(Power power)로 함수 시그니처 변경
    - [X] 현재 거리 1당 문자열 '-'로 바꾸는 기능 추가
- 파워
    - [X] 0 ~ 9 사이의 값으로 랜덤한 파워를 만들 수 있어야 함 (외부용)
    - [X] 입력받은 값으로 파워를 만들 수 있어야함 (패키지 내부용)
    - [X] 0 ~ 9 을 벗어나는 값으로 생성할 수 없음
    - [X] 동등성 비교가 가능해야 함
    - [X] Comparable을 통해 대소 구분이 가능하도록 구현
- Round
    - [X] 차량의 대수를 입력받아서 생성된다.
    - [X] 모든 차량을 1회씩 출발 시킬 수 있다.
    - [X] 실행 후 결과값을 보여줄 수 있다.
    - [X] 기존 차량 일급 콜렉션으로 의존성 변경
- RacingGame
    - [X] 차량 대수와 Round 수를 입력받아서 객체를 생성한다.
    - [X] 주어진 차량 대수와 Round 수만큼 경주를 진행하고 결과를 저장한다.
    - [X] 경기 결과를 출력한다.
- 1차 리뷰 반영
    - [X] RacingGame의 checkResults 메서드명 수정
    - [X] MoveStrategy를 인터페이스화 시키고 관련 기능 및 테스트 수정
        - [X] MoveStratey 인터페이스 추출
        - [X] 동작을 strategy로 제어할 수 있기 때문에 Car 인터페이스 제거
        - [X] MoveStrategy 의존성 주입 구현(Car를 움직일 때 주입받도록 구현 -> UI 단에서부터 받도록 변경)
        - [X] ForceMoveCarFactory 삭제(이제 차량이 아닌 정책 객체가 움직임을 제어함)
        - [X] CarFactory 인터페이스 제거
        - [X] RandomMoveCarFactory를 CarFactory 구체 클래스로 변경
    - [X] `:` 컨벤션 확인 및 수정
    
- [ ] 자동차 경주 우승자 출력 기능 구현
    - [ ] InputView 기능 변경
        - [ ] 입력을 쉼표로 구분된 사용자명을 String으로 받을 수 있도록 변경
        - [ ] 차량 숫자가 아닌 입력된 사용자명 리스트를 관리할 수 있도록 변경
    - [ ] RacingGame 기능 변경
        - [X] String 콜렉션 형태의 참가자 이름을 입력받는 생성자 추가
        - [X] 운전자 이름이 들어간 Cars 일급 콜렉션을 진행하는 run 메서드 추가
        - [ ] result 프로퍼티의 속성의 타입을 String이 아닌 객체로 변경 (출력 메서드에서 출력 포맷 변경하도록 하기 위해서)
        - [ ] 모든 리팩토링 완료 후 기존 생성자, run 메서드 삭제
    - [ ] CarFactory 기능 변경
        - [X] 참가자 목록을 입력받아서 경기에 참가할 차량을 생산하도록 기능 변경
        - [ ] 리팩토링 완료 후 숫자를 입력받아서 차량 리스트를 반환하는 메서드 제거
    - [X] Car 기능 변경
        - [X] 움직인 거리 외 운전자 이름을 관리할 수 있도록 기능 변경
        - [ ] 다른 기능 리팩토링 완료 후 인자 없는 생성자 삭제
    - [ ] Cars 일급 컬렉션 기능 변경
        - [X] CarFactory와 운전자이름 리스트를 입력받아서 일급 컬렉션을 생산하도록 기능 변경
        - [X] create 정적 팩토리 메서드 접근자 변경
        - [ ] 리팩토링 완료 후 수량을 입력 받는 정적 팩토리 메서드(createRandomCarsByNumber) 삭제
    - [ ] Round 기능 삭제
        - [ ] 결과 출력 메서드 삭제
    - [ ] OutputView 기능 변경
        - [ ] getResults를 통해 List<Round>타입을 전달받고 이를 기반으로 출력 결과를 생성하도록 변경
