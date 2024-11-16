package se331.lab.rest.entity;



import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import jakarta.persistence.GeneratedValue;


import jakarta.persistence.Entity;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location;
    private String contactEmail;


}
