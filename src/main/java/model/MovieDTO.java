package model;

import lombok.Data;

@Data
public class MovieDTO {
    private int id; // 영화 번호
    private String title; // 영화 제목
    private String content; // 영화 줄거리
    private int level; // 영화 등급
}
