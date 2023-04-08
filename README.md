# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


<br>
<br>
<br>
<br>
<br>

## 3단계 - 자동차 경주

### 설명
- 초간단 자동차 경주 게임을 구현한다.
- 콘솔 App 이며 아래는 예시
```text
자동차 대수는 몇 대 인가요?
3
시도할 회수는 몇 회 인가요?
5

실행 결과
-
-
-

--
-
--

---
--
---

----
---
----

----
----
-----
```

### 기능적 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 비기능적 요구사항
- 모든 로직에 단위 테스트를 구현한다 (UI로직 제외)
- 로직과 UI 의 분리 : 핵심로직과 Display 부분은 분리되어야 함
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리
- 자바코드 컨벤션을 지키자
  - code-style-java : https://www.jetbrains.com/help/idea/code-style-java.html
- else 예약어를 쓰지 않기
  - PR 제출전 else 로 검색한번 하기
  - early-return 방식으로 else 제거
  - switch/case 도 금지
- commit 로그
  - 커밋로그 컨벤션도 지켜서 개발하기

```text
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```


### step3 자동차경주를 진행하면서 느낀점
- 요구사항의 분리가 참 어렵다
- 요구사항을 분리해서 미리 테스트 코드를 작성하는게 여러운 이유
  - 무엇을 테스트할것인가?
  - 어떻게 테스트할것인가 ?
  - 요구사항은 추상적인데, 이를 테스트를 옮기는것이 설계인거같고 어렵다