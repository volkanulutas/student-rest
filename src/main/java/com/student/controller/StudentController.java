package com.student.controller;

import com.student.config.SwaggerConstant;
import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;
import com.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/student")
@Tag(name = "Student API by volkanulutas")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Student Listing.",
               description = "Listing all students has been created or updated. If there is no students returns empty list.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully returned."),})
    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(studentService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Get student by id.", description = "Id must be long such as 1, 2, 3.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created."),
            @ApiResponse(responseCode = "404", description = "Not found - The student was not found.")})
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@Parameter(name = "id", description = "Student id.") @PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(studentService.getStudentById(id));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Creates a new student", description = "Creates a new student.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created."),
            @ApiResponse(responseCode = "404", description = "Not found - The student was not found.")})
    @PostMapping("/")
    public ResponseEntity<?> createStudent(
            @RequestBody @Parameter(name = "Student", description = "student object.", example = SwaggerConstant.STUDENT_EXAMPLE) Student student) {
        try {
            return ResponseEntity.ok(studentService.saveStudent(student));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Updates a new student", description = "Updates a new student. When the given id is not found, return HTTP 404.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully updated."),
            @ApiResponse(responseCode = "404", description = "Not found - The student was not found.")})
    @PatchMapping("/")
    public ResponseEntity<?> updateStudent(
            @Parameter(name = "Student", description = "student object.", example = SwaggerConstant.STUDENT_EXAMPLE) Student student) {
        try {
            return ResponseEntity.ok(studentService.saveStudent(student));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Deletes a student.",
               description = "Deletes a student with the given id. Id must be long. When the given id is not found, return HTTP 404.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully deleted."),
            @ApiResponse(responseCode = "404", description = "Not found - The student was not found.")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(value = "id") @Parameter(name = "id", description = "Student id.") Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Add all the student list.", description = "Appending all new student list into system.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created.")})
    @PostMapping("/all")
    public ResponseEntity<?> addAll(
            @RequestBody @Parameter(name = "List of Students.", description = "List of Students.", example = SwaggerConstant.STUDENT_LIST_EXAMPLE)
            List<Student> newStudentList) {
        try {
            return ResponseEntity.ok(studentService.addAll(newStudentList));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Clear student list.", description = "Clear student list")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully cleaned.")})
    @DeleteMapping("/clear")
    public ResponseEntity<?> clearAll() {
        try {
            studentService.clearAll();
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
