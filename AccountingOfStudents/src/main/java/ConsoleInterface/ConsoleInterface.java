package ConsoleInterface;

import com.netcracker.accountingofstudents.Students.Repository.StudentsRepository;
import com.netcracker.accountingofstudents.Students.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleInterface {

    private final StudentsRepository studentsRepository;

    @Autowired
    public ConsoleInterface(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    private void addStudents(Scanner scanner) {
        System.out.println("Введите имя студента: ");
        String name = scanner.nextLine();
        Students students = new Students(name);
        studentsRepository.insertStudents(students);
    }

    private void getStudentsById(Scanner scanner) {
        System.out.println("Введите id студента: ");
        try {
            int id = scanner.nextInt();
            Optional<Students> optionalStudents = Optional.ofNullable(studentsRepository.getStudentsById(id));
            if (optionalStudents.isPresent()) {
                System.out.println("Студент: " + optionalStudents.get());
            } else System.out.println("Такого студента нет в базе");

        } catch (InputMismatchException e) {
            System.out.println("Error!");
        }
    }

    private void getAllStudents(Scanner scanner) {
        Iterable<Students> students = studentsRepository.getStudents();

        for (Students students1 : students) {
            System.out.println(students1);
        }
    }

    private void UpdateStudentsScanner(Scanner scanner) {
        System.out.println("Выберите id студента: ");

        try {
            int id = scanner.nextInt();
            Optional<Students> optionalStudents = Optional.ofNullable(studentsRepository.getStudentsById(id));
            Students students;
            if (optionalStudents.isPresent()) {
                students = optionalStudents.get();
                System.out.println("Найден Студент: " + students);

            } else {
                System.out.println("Студент не найден");
                return;
            }
            System.out.println("Добавьте имя этого Студента: ");
            String name = scanner.nextLine();
            students.setFullName(name);
            studentsRepository.insertStudents(students);
            System.out.println("Студент добавлен удачно");
        } catch (InputMismatchException e) {
            System.out.println("Возникла ошибка в методе UpdateStudentsScanner");
        }
    }

    private void deleteStudentById(Scanner scanner) {
        System.out.println("Введите id студента");
        try {
            int id = scanner.nextInt();
            Optional<Students> optionalStudents = Optional.ofNullable(studentsRepository.getStudentsById(id));
            if (optionalStudents.isPresent()) {
                System.out.println("Найден Студет: " + optionalStudents.get());
            } else {
                System.out.println("Студент не найдет");
                return;
            }
//            studentsRepository.deleteStudentById(id);
            System.out.println("Студент удален");
        } catch (InputMismatchException e) {
            System.out.println("Error: Wrong input");
        }
    }
    @PostConstruct
    public void init() {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            String command = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch (command) {

                case "all":
                    getAllStudents(scanner);
                    break;

                case "add":
                    addStudents(scanner);
                    break;

                case "get":
                    getStudentsById(scanner);
                    break;

                case "delete":
                    deleteStudentById(scanner);
                    break;

                case "update":
                    UpdateStudentsScanner(scanner);
                    break;

                case "quit" :
                    System.out.println("Exiting app");
                    quit = true;
                    break;

                default:
                    System.out.println("Unknown command");
            }
        }


    }
}