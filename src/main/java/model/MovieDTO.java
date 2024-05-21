package model;

import lombok.Data;
import lombok.Setter;

@Data
public class MovieDTO {

    private int id; // 영화 번호
    private String title; // 영화 제목
    private String content; // 영화 줄거리
    private int level; // 영화 등급

    public MovieDTO() {

    }
// 리스트에서 객체를 제거하기 위해 필요
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO) o;
            return id == m.id;
        }

        return false;
    }
}
