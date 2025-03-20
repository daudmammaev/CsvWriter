package test.java;

import org.junit.jupiter.api.Test;
import org.writer.WritableImpl;
import org.writer.model.Months;
import org.writer.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WritableTest {

    @Test
    public void testWriteToFile() throws IOException {
        Person person1 = new Person("John Doe", "John Doe", 1, Months.APRIL, 1);
        Person person2 = new Person("Jane Smith", "Jane Smith", 2, Months.MAY, 2);
        WritableImpl writable = new WritableImpl();
        writable.writeToFile(Arrays.asList(person1, person2), "users.csv");

        // Проверка, что файл создан и содержит данные
        assertTrue(Files.exists(Paths.get("generated.csv")));
        String content = new String(Files.readAllBytes(Paths.get("generated.csv")));
        assertTrue(content.contains("John Doe,John Doe,1, APRIL, 1"));
        assertTrue(content.contains("Jane Smith,Jane Smith, 2, MAY, 2"));
    }
}