# 🚀 3단계 - 자동차 경주

## 요구사항
* 사용자 입력값 관리
* [x] 사용자는 자동차 대수와 이동 횟수를 입력할 수 있다.
* [x] 정수가 아닌 값을 입력하면 에러를 던진다.
* [x] 양수가 아닌 값을 입력하면 에러를 던진다.


* 자동차 경주 구현
  * 자동차
  * [X] 자동차는 자신의 위치를 가진다
  * [x] 자동차가 전진하면 위치를 변경한다.

  * 자동차 목록   _(!!! 일급 컬렉션 !!!)_
  * [x] 자동차 목록을 이용하여 객체 생성이 가능하다.
  * [x] 자동차 목록이 가지고 있는 자동차들이 전진하거나 멈추도록 한다.
  * [x] 자동차 목록이 가지고 있는 자동차들의 거리 상태를 반환한다.

  * 랜덤 숫자 반환 
  * [x] 0-9 사이로 랜덤값을 생성한다.

  * 자동차 경주 전진 로직
  * [x] 자동차는 값이 3 이하면 멈추고 4 이상이면 전진한다.
  
  * 게임 방식
  * [x] 경주 시작 준비를 할 때 자동차 대수만큼 자동차 객체를 생성한다.
  * [x] 한 라운드에 모든 자동차를 전진 로직에 따라 이동시킨다
  * [x] 자동차 경주 결과를 리턴한다.


* 자동차 경주 결과 출력
* [x] 자동차 경주 실행 제목을 출력한다.
* [x] 자동차 경주 실행 결과를 출력한다.

---

# 프로그래밍 요구사항 
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다. 
  * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다
* else 예약어를 쓰지 않는다.


### Commit Message 종류 구분

<pre>
<code>feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain) </code>
</pre>


## 참고
* 일급 컬렉션 (https://jojoldu.tistory.com/412)
* 전략 패턴 (https://velog.io/@mohai2618/%EC%A0%84%EB%9E%B5-%ED%8C%A8%ED%84%B4Strategy-Pattern%EC%9D%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80)
