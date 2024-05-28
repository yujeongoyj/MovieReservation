package viewer;

import controller.ReviewController;
import lombok.Setter;
import model.UserDTO;


public class ReviewViewer {
    @Setter
    private UserDTO logIn;
    @Setter
    private ReviewController reviewController;

    public void writeReview(){

    }

}
