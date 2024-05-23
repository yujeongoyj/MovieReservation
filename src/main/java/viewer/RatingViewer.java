package viewer;


import controller.RatingController;
import lombok.Setter;
import model.RatingDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class RatingViewer {
    @Setter
    private BoardViewer boardViewer;
    @Setter
    private RatingDTO ratingDTO;
    @Setter
    private Scanner scanner = new Scanner(System.in);
    @Setter
    private UserDTO logIn;
    @Setter
    private RatingController ratingController;


    public void rateMovie(int movieId) {
        RatingDTO ratingDTO = new RatingDTO();
        String message = "평점을 입력하세요 (1~5):";
        int ratingValue = ScannerUtil.nextInt(scanner, message, 1, 5);
        ratingDTO.setUserId(logIn.getId());
        ratingDTO.setMovieId(movieId);
        ratingDTO.setRate(ratingValue);


        ratingController.addRating(ratingDTO);
        System.out.println("평점이 등록되었습니다.");

    }
}
