package model;

import lombok.Data;

@Data
public class UserDTO {
    private int id; // 회원번호
    private String username; // 아이디
    private String password; // 패스워드
    private String nickname; // 닉네임
    private int level; // 등급
    private boolean isAdmin; // 관리자계정인지


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof UserDTO) {
            UserDTO u = (UserDTO) o;
            return id == u.id;
        }

        return false;
    }
}
