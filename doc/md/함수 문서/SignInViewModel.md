# signIn()

**채택한 방법 : 방법3**

로그인 가능 방법 예시
 - 휴대폰으로 로그인
 - 해당 서비스의 계정으로 로그인
 - 구글 계정으로 로그인

## 방법1. 오버로딩을 통해 정의하기
``` kotlin
// UI
// 이메일로 로그인
fun signIn(email: String): Unit
// 휴대폰으로 로그인
fun signIn(phone: String): Unit
```
문제점 : 매개 변수의 개수 같으면  타입으로 함수를 유추하므로 위처럼 정의가 불가함.

## 방법2. Enum을 넘겨주기
``` kotlin
// UI
// 이메일로 로그인
fun signIn(signInMethod: SignInMethod, vararg args: String): Unit
```
장점 : 하나의 도메인에서 한 번에 처리 가능

단점 : Domain 단에서 매개 변수 처리 힘들다.
```kotlin
// Domain
class SignInUseCase {
    operator fun invoke(signInMethod: SignInMethod, vararg args: String) {
        when (signInMethod) {
            SignInMethod.Email -> {
                val email = args[0]
            }

            SignInMethod.Google -> {
                val google = args[0]
            }

            SignInMethod.Phone -> {
                val phone = args[0]
            }
        }
    }
}
```

## 방법3. DTO와 Enum을 섞어서 넘겨주기
``` kotlin
// UI
fun signInWithPhone(phone: String) {
    SignInUseCase().invoke(signInMethod = SignInMethod.Phone, user = UserDto(phone = phone))
}

fun signInWithEmail(email: String) {
    SignInUseCase().invoke(signInMethod = SignInMethod.Email, user = UserDto(email = email))
}

// Domain
class SignInUseCase {
    operator fun invoke(signInMethod: SignInMethod, user: UserDto) {
        when (signInMethod) {
            SignInMethod.Email -> {
                val email = user.email
            }

            SignInMethod.Google -> {
                val email = user.email
            }

            SignInMethod.Phone -> {
                val phone = user.phone
            }
        }
    }
}
```

장점 : 외부 로직을 들여다 볼 필요가 없이 도메인 로직에 집중 가능.

# 결론
방법3을 선택했다.
로그인의 경우, 여러 가지 로그인 방법이 있겠지만 결국 이들 모두는 로그인이라는 하나의 비즈니스 행위를 위한 작업이다.

따라서, 비즈니스 로직을 처리하는 단일 UseCase로 로그인 방법을 구현하는 것이 옳다고 생각한다.



