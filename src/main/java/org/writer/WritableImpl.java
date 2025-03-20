package org.writer;

import org.writer.Annotations.CsvField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
/**
 * Класс для записи объектов в CSV файл.
 */
public class WritableImpl implements Writable{

    /**
     * Записывает список объектов в CSV файл.
     *
     * @param data     список объектов для записи
     * @param fileName имя файла для сохранения
     * @throws IOException если возникла ошибка при записи в файл
     */
    @Override
    public void writeToFile(List<?> data, String fileName) throws IOException{
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data list cannot be null or empty");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Object item : data) {
                Field[] fields = item.getClass().getDeclaredFields();
                StringBuilder line = new StringBuilder();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(CsvField.class)) {
                        field.setAccessible(true);
                        try {
                            line.append(field.get(item)).append(",");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                writer.write(line + "\n");
            }
        }
    }
}
