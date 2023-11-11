# STUDY

---

## 객체지향 원칙


### 객체 지향 생활 체조 원칙을 통한 의시적인 연습
* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
* 규칙 2: else 예약어를 쓰지 않는다.
* 규칙 3: 모든 원시값과 문자열을 포장한다.
* 규칙 4: 한 줄에 점을 하나만 찍는다.
* 규칙 5: 줄여쓰지 않는다(축약 금지).
* 규칙 6: 모든 엔티티를 작게 유지한다.
* 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
* 규칙 8: 일급 콜렉션을 쓴다.
* 규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

---
## 개발 순서
1. 책임 찾기, REDEME.md 사용하여 필요한 기능들 나열
2. 책임이 어떤 객체에 있을지 배치
3. 리팩토링

---

## 설계
- 책임을 찾가
- 책임에 대한 구분 잘하기, https://github.com/next-step/java-racingcar/pull/5058#discussion_r1390114954
---

## 구현
- 메소드가 너무 많은 일을 하지 않도록 분리하기
- 값 검증시에는 VO 객체로 생성하여 검증
  - https://medium.com/sjk5766/vo-value-object-%EC%A0%95%EB%A6%AC-63c207aa39f6
- 가능한 불변(final)으로 상태값 선언, 가변적인 상태는 추적이 힘듬
- 일급 컬렉션 사용하기 
  - https://tecoble.techcourse.co.kr/post/2020-05-08-First-Class-Collection/
- 원시값은 포장하자, 간단한거는 안해도 무방
- 접근자도 의식하면서 만들기
- 파라미터에 final 쓰기
- 가급적 상속을 쓰지말고 컴포지션 사용
- Domian 객체에 getter/setter 쓰지말기, DTO는 가능
- 삼항연산자는 가급적 지양(취향 차이)
- **객체와 대화하듯이 구현하기**
- 객체와 객체를 비교하기

---

## 테스트
- 테스트 코드명은 명시적으로 작성
- 테스트도 클래스도 각각 개별로 모두 구현
- private 메서드 테스트 
  - private 메서드를 호출하는 public 메서드에서 간접적으로 테스트 
  - private 메서드가 중요 비즈니스 로직인 경우 별도의 객체를 도출하여 개별 테스트, 구조를 개선하는 것도 방법
- 테스트시 Random 객체와 같이 제어가 힘든 경우
    - interface로 변경하여 의존성 역전의 원리 사용
    ```java
    int random = Random().next() // 직접 의존 
    int random = numberGenerator.get() // 인터페이스 의존
    ```
- 테스트를 위한 메서드를 만들지 말기 -> 대신 테스트를 위한 생성자 만들기 
- 테스트 코드가 너무 많은 것도 안 좋다(전부 유지보수 해야함), 최소한으로 작성
- TDD가 불가능한 부분도 존재, 구분법 필요
  - 결과 출력
  - Database CRUD
- 함수형 인터페이스 사용시 테스트가 쉬워짐



### LINK
- AssertJ
  - https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests

---

## 리팩토링
- throws Exception, 오타, 미사용 import 등, 불필요한 것들은 반드시 수정 및 제거
- 프로덕션 코드뿐만 아니라 테스트 코드도 리팩토링 하기
- 메소드의 시그니쳐를 변경할 수 없을 경우 방법 (현장의 레거시 코드 리팩토링시 팁)
  - 접근 제어자를 protected 로 변경
  - 생성자에서 재정의
  ```java
  Car car = new Car("name"){
      @Override
      protected int randomNo(){
          return 1;    
      }
  };
  ```

---

## GIT
- 하나의 커밋 보다는 여러개의 커밋으로 나누어 작업 과정 표현
- Commit Message Conventions
  ```text
  feat (feature)
  fix (bug fix)
  docs (documentation)
  style (formatting, missing semi colons, …)
  refactor
  test (when adding missing tests)
  chore (maintain, package path change, file move)
  ```

