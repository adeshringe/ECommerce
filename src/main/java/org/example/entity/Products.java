package org.example.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    private String productId;
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
    private String productCategory;
    private String productDescription;
}
