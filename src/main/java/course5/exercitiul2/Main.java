package course5.exercitiul2;


import course5.config.ProjectConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
//        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
//
//        }
            ConfigurableApplicationContext context = SpringApplication.run(course5.exercitiul2.Main.class, args);

        StudentService studentService = context.getBean(StudentService.class);
        CourseService courseService = context.getBean(CourseService.class);

        Student student = new Student();
        student.setName("John Doe");
        studentService.save(student);

        Course course = new Course();
        course.setName("Java Programming");
        courseService.save(course);

        studentService.addCourseToStudent(student.getId(), course);

        System.out.println("Studenții cursului '" + course.getName() + "':");
        for (Student studentOfCourse : course.getStudents()) {
            System.out.println(studentOfCourse.getName());
        }
    }
}