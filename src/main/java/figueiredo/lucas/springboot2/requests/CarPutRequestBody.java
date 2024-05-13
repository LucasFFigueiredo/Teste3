package figueiredo.lucas.springboot2.requests;

import lombok.Data;

@Data
public class CarPutRequestBody {
    private Long id;
    private String name;
}
