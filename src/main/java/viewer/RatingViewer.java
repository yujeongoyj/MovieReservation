package viewer;


import controller.RatingController;
import lombok.Getter;
import lombok.Setter;
import model.RatingDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class RatingViewer {
    @Setter
    private BoardViewer boardViewer;
    @Setter
    @Getter
    private RatingDTO ratingDTO;
    @Setter
    private Scanner scanner = new Scanner(System.in);
    @Setter
    private UserDTO logIn;
    @Setter
    private RatingController ratingController;


    public void writeReview(int movieId) {
        if (ratingController.validateUserId(logIn.getId(), movieId)) {
            RatingDTO ratingDTO = new RatingDTO();
            String message = "평론을 작성하세요";
            String review = ScannerUtil.nextLine(scanner, message);

            ratingDTO.setUserId(logIn.getId());
            ratingDTO.setMovieId(movieId);
            ratingDTO.setReview(review);

            ratingController.addRating(ratingDTO);
            System.out.println("평론이 등록되었습니다.");
        }
    }

    public void printReviews(int movieId) {
        ArrayList<RatingDTO> ratings = ratingController.selectAllByMovieId(movieId);
        System.out.println("========================================");
        System.out.println("<평론 목록>");
        for (RatingDTO rating : ratings) {
            System.out.printf("사용자 ID: %d\n", rating.getUserId());
            System.out.printf("평론: %s\n", rating.getReview());
            System.out.println("-------------------------------------");
        }


    }



    public void rateMovie(int movieId) {
        if (ratingController.validateUserId(logIn.getId(), movieId)) {
            RatingDTO ratingDTO = new RatingDTO();
            String message = "평점을 입력하세요 (1~5):";
            int ratingValue = ScannerUtil.nextInt(scanner, message, 1, 5);

            ratingDTO.setUserId(logIn.getId());
            ratingDTO.setMovieId(movieId);
            ratingDTO.setRating(ratingValue);


            ratingController.addRating(ratingDTO);
            System.out.println("평점이 등록되었습니다.");
        }


    }

    public void printRatings(int movieId) {
        ArrayList<RatingDTO> ratings = ratingController.selectAllByMovieId(movieId);
        double averageRating = ratingController.getAverageRating(movieId);
        System.out.println("========================================");
        System.out.println("<전체 평점 목록>");
        for (RatingDTO rating : ratings) {
            System.out.printf("사용자 ID: %d, 평점: %d\n", rating.getUserId(), rating.getRating());
        }

        System.out.printf("전체 평균 평점: %.2f\n", averageRating);
    }

    public void userPrintRatings(int movieId) {
        ArrayList<RatingDTO> ratings = ratingController.selectAllByMovieId(movieId);
    }

    public void reviewerRatings(int movieId) {
        ArrayList<RatingDTO> ratings = ratingController.selectAllByMovieId(movieId);
    }


}
