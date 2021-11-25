4단계 - 자동차 경주 (우승자)
---

### 기능 요구사항
- 각 자동차에 이름 부여 가능
- 자동차의 이름은 5자 초과 불가능
- 자동차 이름은 ,(쉼표)로 구분
- 경주 완료후 우승자가 누군지 알려준다. 우승자는 여러명일 수 있음


### 프로그래밍 요구사항
- 모든 로직에 단위 테스트 구현
- UI(System.out, System.in) 로직은 테스트 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분
- 자바 코드 컨벤션 지키기
- else, switch/case 허용하지 않음
- 함수/메서드의 길이 15줄을 넘기지 않음


### 구현할 패키지 및 클래스
- view
    - InputView Class
    - ResultView Class
- controller (X)
    - main 함수로 대체
- service
    - Race Class
- strategy
    - RunStrategy Interface
        - RandomStrategy Class
- exception
    - MyException Enum
- dto
    - Count Class
    - Position Class
    - Car Class
    - CarGroup Class
    - Record Class 
    - RecordGroup Class
    - NameGroup Class
    

### 구현할 기능 목록
- [x] InputView 입력 클래스 작성
    - 싱글톤으로 구현
- [x] ResultView 출력 클래스 작성 
    - 싱글톤으로 구현
- [x] 예외메세지 Enum 추가
- [x] Count 횟수, Position 위치 클래스 작성
    - plus 메서드
    - get 메서드
- [x] Car 클래스 작성
    - name, position 멤버변수
    - move 메서드
- [x] CarGroup 클래스 작성
    - move 메서드
    - winner 이름 반환하는 메서드
- [x] NameGroup 클래스 작성
    - validation (5자 초과)
    - 생성자는 List를 인자로 받음
- [x] Race 클래스
- [x] RandomStrategy 클래스
    - 기준값을 인자로 받음 (디폴트는 4)
- [x] 리팩토링


### 테스트 항목
- Position Class
    - [ ] plus 메서드는 값을 1 증가시킨다.
    - [ ] 객체 생성시 디폴트값은 0이다.
- Count Class
    - [ ] plus 메서드는 값을 1 증가시킨다.
    - [ ] 0 이하를 인자로 받으면 예외를 던진다.
- Car Class
    - [x] Run 메서드는 전진 혹은 멈춤이다.
    - [ ] 객체 생성시 디폴트 위치는 0이다.
    - [ ] 기준값이 0 미만인 RandomStrategy 를 run 메서드 인자로 받을 시 자동차는 움직이지 않는다.
- CarGroup Class
    - [x] 생성시 전달한 항목만큼 Car의 대수가 들어있다.
- Name Class
    - [x] 5자 초과를 하면 예외를 던진다.
    - [x] 공백을 인자로 받으면 예외를 던진다.
- RandomStrategy Class
    - [ ] 기준값을 0 미만 값을 받으면 전진 가능여부는 false만 반환한다.


### 리뷰전 점검할 부분
- 구현을 우선 진행한 후 리팩토링. 처음부터 잘 짜려고 하지 말아라
- 직관적인 메서드명, 변수명
- getter, setter이 아닌 메세지를 보내야한다
- 모든 원시값과 문자열을 포장한다
- 테스트 설명은 상황, 행위, 결과를 포함하여 간략하게 작성한다
- 불변한 객체를 생성한다
- getter은 ui 출력할 때만 사용한다
- domain에 너무 많은 일을 주지 말자.
- MVC 패턴으로 구현하기 - main 함수를 Controller 라고 생각하자


### 1차 리뷰내용 정리
- 생각이 너무 많아 오히려 난잡하다
- 싱글톤 패턴의 지연 로딩
- 사용하지 않는 임포트 삭제
- 비교는 Comparable
- Service Layer는 Stateless해야한다
