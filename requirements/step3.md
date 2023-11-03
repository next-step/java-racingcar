# 🚀 3단계 - 자동차 경주

## TODO
* 사용자 입려값 관리
* [ ] 사용자는 자동차 대수와 이동 횟수를 입력할 수 있다.
* [ ] 정수가 아닌 값을 입력하면 에러를 던진다.
* [ ] 양수가 아닌 값을 입력하면 에러를 던진다.


* 자동차 경주 구현
  * 자동차
  * [ ] 자동차는 자신의 위치를 가진다
  * [ ] 자동차가 전진하면 위치를 변경한다.

  * 자동차 경주 전진 로직
  * [ ] 0-9 사이로 랜덤값을 생성한다.
  * [ ] 자동차는 값이 3 이하면 멈추고 4 이상이면 전진한다.
  
  * 자동차 경주 방식
  * [ ] 한 라운드에 모든 자동차를 전진 로직에 따라 이동시킨다.
  * [ ] 자동차 경주 결과를 리턴한다.

* 자동차 경주 출력 관리
* [ ] 자동차 갯수와 이동 횟수를 입력받는 설명 사항을 출력한다.
* [ ] 자동차 경주 실행 결과를 출력한다.

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