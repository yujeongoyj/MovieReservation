package controller;

import model.RatingDTO;
import model.UserDTO;

import java.util.ArrayList;

public class RatingController {


    private ArrayList<RatingDTO> list;
    private ArrayList<UserDTO> userList;
    private int nextId;

    public RatingController() {
        list = new ArrayList<>();
        userList = new ArrayList<>();
        nextId = 1;
    }

    // 사용자 데이터 추가하는 메서드
    public void addUser(UserDTO user) {
        userList.add(user);
    }

    // 사용자 레벨을 가져오는 메서드
    public int getUserLevel(int userId) {
        for (UserDTO userDTO : userList) {
            if (userDTO.getId() == userId) {
                return userDTO.getLevel();
            }
        }
        return -1; // 사용자를 찾지 못한 경우 -1 반환 또는 예외 처리
    }

    public void addRating(RatingDTO ratingDTO) {
        ratingDTO.setId(nextId++);
        list.add(ratingDTO);
    }


    public ArrayList<RatingDTO> selectAllByMovieId(int movieId) {
        ArrayList<RatingDTO> result = new ArrayList<>();
        for (RatingDTO rating : list) {
            if (rating.getMovieId() == movieId) {
                result.add(rating);
            }
        }
        return result;
    }

    public double getAverageRating(int movieId) {
        ArrayList<RatingDTO> ratings = selectAllByMovieId(movieId);
        if (ratings.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (RatingDTO rating : ratings) {
            sum += rating.getRating();
        }

        return sum / ratings.size();
    }

    public boolean validateUserId(int userId, int movieId) {

            for (RatingDTO rating : list) {
                if (rating.getId() == userId && rating.getMovieId() == movieId) {
                    System.out.println("한번만 가능합니다.");
                    return false;
                }
            }

        return true;
    }
}


