package com.student.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Schema(description = "id of the student.", name = "id", type = "Long", example = "1")
    private Long id;

    @Schema(description = "´name of the student.", name = "name", type = "String", example = "Alp Özözer")
    private String name;

    @Schema(description = "grade of the student.", name = "grade", type = "Double", example = "90.0")
    private Double grade;
}
