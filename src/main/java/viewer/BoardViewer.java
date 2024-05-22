package viewer;


import controller.MovieController;
import controller.UserController;
import lombok.Setter;
import lombok.With;
import model.UserDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class BoardViewer {

    @Setter
    private UserController userController;
    @Setter
    private Scanner scanner;
    @Setter
    private MovieController movieController;
    @Setter
    private UserDTO logIn;
    @Setter
    private MovieViewer movieViewer;
    @Setter
    public UserViewer userViewer;
    @Setter
    private TheaterViewer theaterViewer;
    @Setter
    private ScreenViewer screenViewer;


    public void adminMenu1() {
        String message = "1. 영화 등록 2. 영화 수정 3.  뒤로가기";
        int menuChoice = ScannerUtil.nextInt(scanner, message);
        if (menuChoice == 1) {
            movieViewer.addMovie();
        } else if (menuChoice == 2) {
            movieViewer.modifyMovie();
        }
    }

    public void adminMenu2() {
        String message = "1. 극장 등록 2. 극장 수정 3. 뒤로가기";
        int menuChoice = ScannerUtil.nextInt(scanner, message);

        if (menuChoice == 1) {
            theaterViewer.addTheater();
        } else if (menuChoice == 2) {
            theaterViewer.modifyTheater();
        }
    }

    public void adminMenu3() {
        String message = "1. 상영정보 등록 2. 상영정보 수정 3. 뒤로가기";
        int menuChoice = ScannerUtil.nextInt(scanner, message);
        if(menuChoice == 1) {
            screenViewer.addScreen();
        } else if(menuChoice ==2 ){
            screenViewer.modifyScreen();
        }

    }


}













