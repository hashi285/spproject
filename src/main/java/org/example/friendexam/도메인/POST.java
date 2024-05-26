package org.example.friendexam.도메인;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class POST {
    @Id
    private Long id;
    private String name;
    private String title;
    private String password;
    private String content;

}
