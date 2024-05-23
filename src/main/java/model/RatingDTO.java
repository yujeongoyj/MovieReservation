package model;

import lombok.Data;

@Data
public class RatingDTO {
    private int id; // 평점번호
    private int userId; // 작성 회원 번호
    private int movieId; // 영화 번호
    private int rate; // 평점
    private String review; // 평론
}
