package main;


import controller.ScreenController;
import controller.TheaterController;
import controller.UserController;
import controller.MovieController;
import model.MovieDTO;
import model.ScreenDTO;
import model.TheaterDTO;
import viewer.*;


import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        // 입력에 사용할 Scanner 클래스 객체
        Scanner scanner = new Scanner(System.in);

        // 각종 컨트롤러 클래스 객체
        UserController userController = new UserController();
        MovieController movieController = new MovieController();
        TheaterController theaterController = new TheaterController();
        ScreenController screenController = new ScreenController();

        // 각종 뷰어 클래스 객체
        UserViewer userViewer = new UserViewer();
        BoardViewer boardViewer = new BoardViewer();
        MovieViewer movieViewer = new MovieViewer();
        TheaterViewer theaterViewer = new TheaterViewer();
      ScreenViewer screenViewer = new ScreenViewer();


        MovieDTO movieDTO = new MovieDTO();
        TheaterDTO theaterDTO = new TheaterDTO();
        ScreenDTO screenDTO = new ScreenDTO();

        // setter를 사용한 의존성 주입
        userViewer.setScanner(scanner);
        userViewer.setUserController(userController);
        userViewer.setBoardViewer(boardViewer);
        screenViewer.setScreenController(screenController);
        screenViewer.setMovieController(movieController);
        screenViewer.setTheaterController(theaterController);



        boardViewer.setScanner(scanner);
        boardViewer.setUserController(userController);
        boardViewer.setMovieController(movieController); // MovieController 설정
        boardViewer.setMovieViewer(movieViewer);
        boardViewer.setTheaterViewer(theaterViewer);
        boardViewer.setScreenViewer(screenViewer);

        movieViewer.setScanner(scanner);
        movieViewer.setMovieController(movieController);
        userViewer.setMovieController(movieController); // UserViewer에 MovieController 설정
        movieDTO.setId(movieDTO.getId());
        theaterViewer.setTheaterController(theaterController);


        screenViewer.setMovieViewer(movieViewer);
        screenViewer.setScreenController(screenController);
        screenViewer.setTheaterViewer(theaterViewer);

        boardViewer.setUserViewer(userViewer);

        userViewer.showIndex();
    }
}
