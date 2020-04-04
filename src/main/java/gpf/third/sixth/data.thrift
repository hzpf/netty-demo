namespace java gpf.third

typedef i32 int
typedef i64 long
typedef string String

struct Person {
    1: optional String name,
    2: optional int id,
    3: optional String email
}

exception FuckException {
    1: optional String message,
    2: optional String stack,
    3: optional String date
}

service FuckService {
    void savePerson(1: required Person person) throws (1: FuckException fuckException)
}