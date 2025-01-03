package dev.aleckrh.swagger_example.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    private String title;
    private String author;
    private boolean available;
}
