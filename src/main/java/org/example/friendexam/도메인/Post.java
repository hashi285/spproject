package org.example.friendexam.도메인;


import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Post {
    @Id
    private Long id;
    private String name;
    private String title;
    private String password;
    private String content;

}
