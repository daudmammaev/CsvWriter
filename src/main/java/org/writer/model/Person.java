package org.writer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.writer.Annotations.CsvField;

@Data
@Builder
@AllArgsConstructor
public class Person {
    @CsvField
    private String firstName;
    @CsvField
    private String lastName;
    @CsvField
    private int dayOfBirth;
    @CsvField
    private Months monthOfBirth;
    @CsvField
    private int yearOfBirth;

}
