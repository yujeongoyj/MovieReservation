package main;


import controller.UserController;
import controller.MovieController;
import model.MovieDTO;
import viewer.BoardViewer;
import viewer.MovieViewer;
import viewer.UserViewer;
import viewer.BoardViewer;


import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        // 입력에 사용할 Scanner 클래스 객체
        Scanner scanner = new Scanner(System.in);

        // 각종 컨트롤러 클래스 객체
        UserController userController = new UserController();
        MovieController movieController = new MovieController();

        // 각종 뷰어 클래스 객체
        UserViewer userViewer = new UserViewer();
        BoardViewer boardViewer = new BoardViewer();
        MovieViewer movieViewer = new MovieViewer();

        MovieDTO movieDTO = new MovieDTO();

        // setter를 사용한 의존성 주입
        userViewer.setScanner(scanner);
        userViewer.setUserController(userController);
        userViewer.setBoardViewer(boardViewer);


        boardViewer.setScanner(scanner);
        boardViewer.setUserController(userController);
        boardViewer.setMovieController(movieController); // MovieController 설정
        boardViewer.setMovieViewer(movieViewer);

        movieViewer.setScanner(scanner);
        movieViewer.setMovieController(movieController);
        userViewer.setMovieController(movieController); // UserViewer에 MovieController 설정
        movieDTO.setId(movieDTO.getId());

        userViewer.showIndex();
    }
}
