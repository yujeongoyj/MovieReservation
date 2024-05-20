package model;

import lombok.Data;

@Data
public class TheaterDTO {
    private int id; // 극장 번호
    private String name; // 극장 이름
    private String locate; // 극장 위치
    private String num; // 극장 전화번호
}
