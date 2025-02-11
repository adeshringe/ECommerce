package org.example.entity;

import jakarta.annotation.Generated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Suppliers {

    @Id
    private String supplierId;
    private String supplierName;
}
