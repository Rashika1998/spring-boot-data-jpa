package com.rashika.learningspringdatajpa.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                        name = "email_id_unique",
                        columnNames = "email_address"

                )

)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false,
            unique = true
    )
    private String emailId;

    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

}
