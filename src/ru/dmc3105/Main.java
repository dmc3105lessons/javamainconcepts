import ru.dmc3105.service.RegisterUserCommand;
import ru.dmc3105.service.UserService;


void main() {
    UserService userService = new UserService();
    userService.registerUser(RegisterUserCommand.of(null, null));
    userService.registerUser(RegisterUserCommand.of("bob", null));
    userService.registerUser(RegisterUserCommand.of("bill", 12));

    userService.getUsers().forEach(System.out::println);
}