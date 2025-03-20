package org.writer;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import net.datafaker.Faker;
import org.writer.Annotations.CsvField;
import org.writer.model.Months;
import org.writer.model.Person;
import org.writer.model.Student;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Faker faker = new Faker();
        List<Person> personList = new ArrayList<>();
        List<Student> studentsList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            personList.add(new Person(faker.name().firstName(),
                    faker.name().lastName(),
                    i + 1,
                    Months.APRIL,
                    i + 1));
        }

        for (int i = 0; i < 10; i++) {
            List<String> stringList = new ArrayList<>();
            for (int j = 0; j < 5; j++){
                stringList.add(faker.name().name());
            }
            studentsList.add(new Student(faker.name().name(), stringList));


        }

        try {
            WritableImpl writable = new WritableImpl();
            writable.writeToFile(personList, "generated.csv");
            writable.writeToFile(studentsList,"generatedstudent.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
