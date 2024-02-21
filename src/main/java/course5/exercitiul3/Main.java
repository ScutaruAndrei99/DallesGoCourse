package course5.exercitiul3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        UserService userService = context.getBean(UserService.class);

        User newUser = new User("John Doe", "john@example.com", 25);
        userService.saveUser(newUser);

        User existingUser = userService.findUserById(1L);
        if (existingUser != null) {
            existingUser.setName("Jane Doe");
            userService.updateUser(existingUser);
        } else {
            System.out.println("Utilizatorul cu id-ul specificat nu a fost găsit.");
        }

        System.out.println("Lista utilizatorilor:");
        userService.getAllUsers().forEach(System.out::println);

    }
}

