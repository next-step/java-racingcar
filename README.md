# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 자동차 경주 3단계
###📌요구사항
>### 기능 요구사항
>1. 초간단 자동차 경주 게임을 구현한다.
>2. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
>3. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
>4. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
>5. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
> 
> ### 프로그램 요구사항
> - 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
>>- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다. 
>>- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
> - 자바 코드 컨벤션을 지키면서 프로그래밍한다.
>>- 이 과정의 Code Style은 intellij idea Code Style. Java을 따른다.
>>- intellij idea Code Style. Java을 따르려면 code formatting 단축키(⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
>- else 예약어를 쓰지 않는다.
>>- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다. 
>>- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

###📝기능 목록
>
>#### TestCode 작성에 따른 기능구현
- [x] 자동차 이동 test
- [x] 입력받은 자동차대수와 이동횟수에 따라 자동차 레이싱 test
- [x] 입력 출력 구현
- 리팩토링 (리뷰 반영)
  - [x] No newline end of file : setting
  - [x] 함수명과 함수안의 코드와의 연관성이 불일치 하는 부분의 함수 수정
  - [x] 해당 클래스에 맞는 역할 분담 조직
  - [x] 불필요한 역할 분리, 개행 코드 수정 반영
  - [x] private 생성자 삭제 왜 필요하지 않은지 생각해보기.
  <br> 불필요한 객체 생성 제한, 해당 인스턴스의 생성이 무의미하거나 불필요하게 생성하는것을 방지할 때 사용함. 
  - [x] 자바 컨벤션 지키기
  - [x] inputAnswer함수 -> 정수를 받는다는 의미의 함수명으로 변경
  - [x] 테스트 이름 수정


---
## 자동차 경주 4단계
###📌요구사항
> 기능 요구사항
- [x] 각 자동차에 이름 입력. - 입력하는 값이 유효하지 않으면 재 입력 받음.
<br> - 자동차 이름은 5자를 초과할 수 없다.
<br> - 자동차의 이름은 쉼표(,)를 기준으로 입력받게 하고 그 기준으로 구분한다.
<br> - 자동차를 입력한 이름의 숫자 만큼 자동차 대수 생성
- [x] 자동차 이름과 위치 정보를 가지는 Car 객체를 추가 구현.
- [x] 전진하는 자동차를 이름 함께 출력.
- [x] Cars 의 position 과 ResultView 분리.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지 출력. (우승자 한명 이상 가능)

> 프로그래밍 요구사항
- [x] indent depth allowed 1.
- [x] 함수의 길이가 15라인 넘어가지 않도록 구현. (함수는 한가지 일만 하도록)
- [x] 모든 로직에 단위테스트 구현. 단 UI(System.out, System.in)로직 제외.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
- [x] else 예약어 쓰지 않는다. (swtich/case 도 허용하지 않음.)

> 기능 목록 및 commit 로그 요구사항
- [x] 기능 구현 전 README.md 파일에 구현할 기능 목록 정리해 추가.
- [x] git 의 commit 단위 : README.md파일에 정리한 기능 목록 단위로 추가.

> 😘리뷰 반영
- [x] 컨벤션 오류 수정 (getter변수위치, asserthat 간략화, 함수이름) 
- [x] 개행 "\n" 처리 수정
- [x] Car 생성자 이용 및 생성자 중복 제거
- [x] RandomValueMovingStrategy에서 랜덤숫자 생성, 움직일지의 여부 역할 분리
- [x] 입력값에 대하여 exception 처리 수정 및 메세지 상세화
- [x] carDTO, carsDTO 의 역할에 맞게 수정 -> Record
- [x] WrapperClass : CarPosition, CarName 활용
- [x] Cars - findWinner 함수에서 객체의 역할 수정
- [x] ResultView 기록받아 출력 구현
- [ ] Cars 의 일급컬렉션 사용 의미있게 - 이 부분은 더 고민할 사항.
- [x] 상수 public -> private로 접근제한자 설정 변경.
- [x] 상수 이름 수정이나 불필요한 상수 삭제.
- [x] 메서드, 파라미터명, test 명 수정.
- [x] carname trim 수정
- [x] carpoint 추가시에 new로 생성함  
- [x] InputView 유효성 검사 제외 - 중복 유효성 제거
- [x] getSize 함수 삭제 후 test코드 재 작성.
- [x] 자동차 이름 받아서 split처리 inputView에서 처리하도록 로직 재구성
- [x] Car 객체 불변성 적용
- [x] isWinner 함수 네이밍이 의도와 맞게 isMaxPosition 으로 변경 
- [x] 메서드 이름 수정
  - isMaxPosition 
  - 차이름 null과 empty(blank)의미 포함하게 함수 네이밍 변경
  - 차이름 값 없을 때 상수 이름 의미 있게 수정
  - finish -> findFinalWinner
  - inputString -> inputCarName


---
## 자동차 경주 5단계
###📌리팩토링 요구사항
> 기능 요구사항
- [x] 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현
  -  MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현
- [x] 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행
> 기능 목록
- [x] winner 를 CarsRecord에 담아 로직 구성
- [x] Controller 추가 

> 😘리뷰 반영
- [x] Cars에서 Cars 생성 여부 체크
- [x] 의미있는 메서드 분리 적용
- [x] 컨트롤러 역할
- [x] 자바 리팩토링 체크
