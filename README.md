# 자동차 경주 게임
  
## Step 5. 자동차 경주(리팩토링) :car:

`newRacingCar` 패키지에 스스로 생각하여 새롭게 리팩토링을 한다. 
### 프로그래밍 요구사항 
* 모든 로직에 단위 테스트를 구현한다.
* 핵심 로직을 구현하는 코드와 UI 담당 로직을 구분한다.
* 자바 코드 컨벤션을 지킨다.
* `else` 예약어, `switch/case`를 사용하지 않는다.
* 함수의 길이가 15라인을 넘어가지 않도록 구현한다.

### 구현 기능 목록
**Car**
- [X] 자동차 이름과 위치 정보를 가지는 자동차 객체를 구현한다.
- [X] 자동차 이름은 5자를 초과 할 수 없다.

**RacingCarGame**
- [X] 사용자가 입력한 이름의 숫자만큼 자동차 대수를 생성한다.
- [X] 자동차 경주 게임이 완료한 후 우승자를 알려준다. 우승자는 한 명 이상일 수 있다.

**Utils**
- [X] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

### Commit Message Convension 
**나만의 양식 : [종류] 커밋 메세지**
* feat (feature) 기능 추가
* fix (bug fix)
* docs (documentation)
* style (formatting, missing semi colons, ..)
* refactor
* test (when adding missing tests)
* chore (maintain)