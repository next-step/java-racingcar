# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Commit Message Convention
* [AngularJS Coding Convention](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 을 따르도록 한다.
  * 형식
    ```
    <타입>: <설명>
    
    <본문(선택사항)>
    
    <꼬리말(선택사항)>
    ```
  * 커밋 타입
    * `feat`: 새로운 기능 추가
    * `fix`: 버그 수정
    * `docs`: 문서 수정
    * `style`: 포매팅, 세미콜론 누락 등
    * `refactor`
    * `test`: 테스트 코드 관련
    * `chore`: 빌드 업무 수정, 패키지 매니저 수정, gitignore 등 설정 수정 등 
* 추가 참고할 사이트 : [Conventional Commits](https://www.conventionalcommits.org/ko/v1.0.0-beta.4/)

## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 실행결과 예시
```
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
