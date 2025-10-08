package com.bhawarth.springbootMapper.mapper;

import com.bhawarth.springbootMapper.dto.StudentDTO;
import com.bhawarth.springbootMapper.entities.Student;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-08T16:18:35+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public StudentDTO mapStudentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setName( student.getUsername() );
        if ( student.getDateOfBirth() != null ) {
            studentDTO.setDob( dateTimeFormatter_yyyy_MM_dd_0159776256.format( student.getDateOfBirth() ) );
        }
        studentDTO.setId( student.getId() );
        studentDTO.setPassword( student.getPassword() );
        studentDTO.setStatus( student.getStatus() );

        return studentDTO;
    }
}
