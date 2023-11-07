# 자동차 경주 게임

## 기능 요구사항

- [X] 한 자동차가 60% 확률로 전진하고 결과를 반환한다
- [ ] 여러 자동차가 60% 확률로 전진하고 결과를 반환한다
- [ ] 여러 자동차가 여러 번 60% 확률로 전진하고 결과를 반환한다
- [ ] 사용자의 입력을 받아 m대의 자동차가 n번 60% 확률로 전진하도록 하고 게임 결과를 출력한다

## 클래스 다이어그램을 통한 설계

```mermaid
classDiagram
    RacingGameConsole --> RacingGame
    RacingGame --> Cars
    Cars o-- Car

    class RacingGameConsole {
        -RacingGame racingGame
        -InputView InputView
        -OutputView OutputView

        +RacingGameConsole(racingGame, inputView, outputView)
        +start()
    }

    class RacingGame {
        -Cars cars
        -int roundAmount

        +RacingGame(driveStartegy, carAmount, roundAmount)
        +play() RacingGameResult
    }
    
    class Cars {
        -List cars

        +Cars(driveStrategy, carAmount)
        +drive() RoundResult
    }

    class Car {
        -int drives

        +Car(driveStrategy)
        +drive() DriveResult
    }
    
    RacingGameConsole *-- RacingGameInputView
    RacingGameConsole *-- RacingGameOutputView

    class RacingGameInputView {
        <<inteface>>
        +readCarAmount() int
        +readRoundAmount() int
    }

    class RacingGameOutputView {
        <<inteface>>
        +printGameResult(gameResult)
    }
```

```mermaid
classDiagram
    RacingGameResult o-- RoundResult
    RoundResult o-- DriveResult

    DriveStrategy ..|> SixtyPercentDriveStrategy
    
    class RacingGameResult {
        -List roundResults
        
        +RacingGameResult()
        +report(roundResult)
        +toString()
    }

    class RoundResult {
        -List driveResults

        +RoundResult()
        +report(driveResult)
        +toString()
    }

    class DriveResult {
        -int drives
        
        +DriveResult(drives)
        +toString()
    }

    class DriveStrategy {
        <<interface>>
        +canDrive() boolean
    }

    class SixtyPercentDriveStrategy {
        +canDrive() boolean
    }

```
