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


    public void addUser(UserDTO user) {
        userList.add(user);
    }

    // 사용자 레벨을 가져오는
    public int getUserLevel(int userId) {
        for (UserDTO userDTO : userList) {
            if (userDTO.getId() == userId) {
                return userDTO.getLevel();
            }
        }
        return -1;
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
                if(!(getUserLevel(rating.getUserId()) == 2)) {
                    if (rating.getId() == userId && rating.getMovieId() == movieId) {
                        System.out.println("한번만 가능합니다.");
                        return false;
                    }
                }

            }

        return true;
    }





    public double criticAverage(int movieId) {
        ArrayList<RatingDTO> ratings = selectAllByMovieId(movieId);
        double sum = 0;
        for (RatingDTO rating : ratings) {
            int userLevel = getUserLevel(rating.getUserId());
            if(userLevel == 2) {
                sum += rating.getRating();
            }
        }

        return sum / ratings.size();

        //        int criticCount = 0;
//        double criticSum = 0;
//
//        for (RatingDTO rating : ratings) {
//            int userId = rating.getUserId();
//            int userLevel = getUserLevel(userId);
//            if (userLevel == 2) { // 평론가 레벨
//                criticSum += rating.getRating();
//                criticCount++;
//            }
//        }
//        if (criticCount == 0) {
//            return 0;
//        }
//        return criticSum / criticCount;
    }

    public double userAverage(int movieId) {
        ArrayList<RatingDTO> ratings = selectAllByMovieId(movieId);
        int userCount = 0;
        double userSum = 0;

        for (RatingDTO rating : ratings) {
            int userId = rating.getUserId();
            int userLevel = getUserLevel(userId);
            if (userLevel == 1) { // 일반 회원 레벨
                userSum += rating.getRating();
                userCount++;
            }
        }

        if (userCount == 0) {
            return 0;
        }

        return userSum / userCount;
    }



}


