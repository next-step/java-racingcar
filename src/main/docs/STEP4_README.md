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
- controller
    - RaceController Class
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
- main method
    

### 구현할 기능 목록
- [ ] InputView 입력 클래스 작성
    - 싱글톤으로 구현
- [ ] ResultView 출력 클래스 작성 
    - 싱글톤으로 구현
- [ ] 예외메세지 Enum 추가
- [ ] Count 횟수, Position 위치 클래스 작성
    - plus 메서드
    - get 메서드
- [ ] Car 클래스 작성
    - name, position 멤버변수
    - move 메서드
- [ ] CarGroup 클래스 작성
    - move 메서드
    - winner 이름 반환하는 메서드
- [ ] NameGroup 클래스 작성
    - validation (5자 초과)
    - 생성자는 List를 인자로 받음
- [ ] Race 클래스
- [ ] Race Controller 클래스
- [ ] RandomStrategy 클래스
    - 기준값을 인자로 받음 (디폴트는 4)
- [ ] 리팩토링


### 테스트 항목
- Position Class
    - [ ] plus 메서드는 값을 1 증가시킨다.
    - [ ] 객체 생성시 디폴트값은 0이다.
- Count Class
    - [ ] plus 메서드는 값을 1 증가시킨다.
    - [ ] 0 이하를 인자로 받으면 예외를 던진다.
- Car Class
    - [ ] Run 메서드는 전진 혹은 멈춤이다.
    - [ ] 객체 생성시 디폴트 위치는 0이다.
    - [ ] 기준값이 0 미만인 RandomStrategy 를 run 메서드 인자로 받을 시 자동차는 움직이지 않는다.
- CarGroup Class
    - [ ] 생성시 전달한 항목만큼 Car의 대수가 들어있다.
- Name Class
    - [ ] 5자 초과를 하면 예외를 던진다.
    - [ ] 공백을 인자로 받으면 예외를 던진다.
- RandomStrategy Class
    - [ ] 기준값을 0 미만 값을 받으면 전진 가능여부는 false만 반환한다.
