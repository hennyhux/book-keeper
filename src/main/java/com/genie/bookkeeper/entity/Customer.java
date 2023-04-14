package com.genie.bookkeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "customer_id")
    private String id;

    @Column(name = "customer_firstName")
    private String customerFirstName;

    @Column(name = "customer_lastName")
    private String customerLastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;
}
