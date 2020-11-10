**자동차 경주 STEP4**
--

<br>

**Car Racing Package(`step4-1`)**

![](https://i.ibb.co/Y2xvDDN/image.png)

**Car Racing Package(`step4-2`)**

![](https://i.ibb.co/Jxp2WzD/image.png)

> 리뷰 부탁드립니다 ~ !! 😄

<br>

**기능 요구사항**
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

<br>

**실행결과**

![](https://i.ibb.co/PxQwvxf/image.png)

<br>

**힌트**

- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
    - indent가 2이상인 메소드의 경우 메소드를 분리하면 indent를 줄일 수 있다.
    - else를 사용하지 않아 indent를 줄일 수 있다.
- 자동차 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메소드를 활용한다.
- 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
- 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.

<br>

**프로그래밍 요구사항**

- **indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.**
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- **함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.**
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

<br>

**참조**

- [javaguide](https://google.github.io/styleguide/javaguide.html )
- [myeonguni.tistory](https://myeonguni.tistory.com/1596)

<br>

**`step4-1` 리팩토링 요구사항**

1. 자동차의 기록을 `private int position;` 으로 카운팅 하게 변경
2. 경기 결과 `List<RaceResult>`를 가지고 있는 일급 컬렉션(예: RaceRound)을 만들어 리턴
3. 외부에서 객체의 상태를 변경할 수 있는 set() 사용을 지양해야 합니다.
4. 모든 메세지 상수화

<br>

**리팩토링 참고**
- [일급 컬렉션 (First Class Collection)의 소개와 써야할 이유](https://jojoldu.tistory.com/412)
- [일급 컬렉션을 사용하는 이유](https://woowacourse.github.io/javable/2020-05-08/First-Class-Collection)


<br>

<br><br>

---

<br><br>

**자동차 경주 STEP3**
--

<br>

**Car Racing Package(`step3-1`)**

![](https://i.ibb.co/frh181t/image.png)

**Car Racing Package(`step3-2`)**

![](https://i.ibb.co/2WgP78v/image.png)

**Car Racing Package(`step3-3`)**

![](https://i.ibb.co/XjnMfzX/image.png)

<br><br>

**기능 요구사항**

- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

<br>

**실행결과**

![](https://i.ibb.co/SJTBtGR/image.png)

<br>

**프로그래밍 요구사항**

- **모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외**
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- **자바 코드 컨벤션을 지키면서 프로그래밍한다.**
- **else 예약어를 쓰지 않는다.**
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

**기능 목록 및 commit 로그 요구사항**

- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  - 참고문서: `AngularJS Commit Message Conventions`

**참조**

- [자바 코드 컨벤션 #1](https://google.github.io/styleguide/javaguide.html)
- [자바 코드 컨벤션 #2](https://myeonguni.tistory.com/1596)
- [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
```
  feat (feature)
  fix (bug fix)
  docs (documentation)
  style (formatting, missing semi colons, …)
  refactor
  test (when adding missing tests)
  chore (maintain)
```

<br>

**`step3-1` 리팩토링 요구사항**

1. `InputView` - 유틸성 클래스 상태메소드를 정적메소드로 리팩토링
2. 상수 메세지 유틸클래스 `private 생성자`를 통해 객체 생성방지
3. 초기값 `"- "` 설정 -> 해당사항은 오류 😫
4. `Car` 객체에서 `Random` 값 생성 부분을 분리하여 움직임을 담당하는 객체를 생성하도록 리팩토링
5. 자동차의 위치 그리는 `UI 로직을 비지니스 로직에서 분리`
6. `List<Car>` Wrapping한 일급컬렉션 Cars로 리팩토링
7. while문 내에서 Stream을 사용할떄 리팩토링
8. 따로 경기 기록을 관리하는 객체 생성
9. 테스트용도의 불필요 메소드 제거
10. 메소드 네이밍에 대한 고민

<br>

**리팩토링 참고**
- [일급 컬렉션 (First Class Collection)의 소개와 써야할 이유](https://jojoldu.tistory.com/412)
- [일급 컬렉션을 사용하는 이유](https://woowacourse.github.io/javable/2020-05-08/First-Class-Collection)
- [Strategy 패턴/전략패턴](https://lee1535.tistory.com/93)
- [Test Stub이란 ?](https://beomseok95.tistory.com/294)


<br>

**`step3-2` 리팩토링 요구사항**

1. `2개 이상의 인스턴스 변수를 가진 클래스` 를 쓰지 않는다.
2. 의미 전달이 어려운 객체 네이밍 변경
3. Random 값에 대한 테스트 필요성으로 인터페이스 기반 전략패턴 사용
4. `한 메서드에 오직 한 단계의 들여쓰기만 한다.`
5. 매직넘버 상수화!
6. 무조건 전진하는 테스트 객체 생성
7. `모든 로직에 단위 테스트를 구현한다`


<br>

**리팩토링 참고**
- [객체지향 생활 체조 원칙 9가지(from 소트웍스 앤솔러지)](https://jamie95.tistory.com/entry/Java-%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5-%EC%83%9D%ED%99%9C-%EC%B2%B4%EC%A1%B0-%EC%9B%90%EC%B9%99-9%EA%B0%80%EC%A7%80-from-%EC%86%8C%ED%8A%B8%EC%9B%8D%EC%8A%A4-%EC%95%A4%EC%86%94%EB%9F%AC%EC%A7%80)
- [Strategy 패턴/전략패턴](https://lee1535.tistory.com/93)
- [Test Stub이란 ?](https://beomseok95.tistory.com/294)
