import ru.dmc3105.Verifiable;
import ru.dmc3105.domain.user.User;


void main() {
    var user = User.unknown();
    var user2 = User.withName("Alex");
    var user3 = User.withPersonalData("Alex", 12);

    List<User> users = List.of(user, user2, user3);

    List<String> usernames = users.stream()
            .map(User::getName)
            .toList();

    Verifiable verifiable = user2;

    System.out.println(verifiable.getStatus());
}