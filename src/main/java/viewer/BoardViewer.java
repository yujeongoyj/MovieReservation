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
        if (menuChoice == 1) {
            screenViewer.addScreen();
        } else if (menuChoice == 2) {
            screenViewer.modifyScreen();
        }

    }


    public void showMenu() {
        String message = "1. 영화정보 보기 2. 극장 정보 보기 3. 상영정보 보기 4. 뒤로가기";
        int menuChoice = ScannerUtil.nextInt(scanner, message);
        if (menuChoice == 1) {
            movieViewer.movieList();
            message = "상세보기할 영화 번호를 선택하세요 / 0으로 뒤로가기 ";
            int choice = ScannerUtil.nextInt(scanner, message);
            movieViewer.userPrintOne(choice);
            message = "1. 평점주기 2. 평론하기 3. 뒤로가기";
            int choice2 = ScannerUtil.nextInt(scanner, message);
            if (choice2 == 1) {

            } else if (choice2 == 2) {
               if(logIn.getLevel()==2) {
                   System.out.println("평론할거임?");
               } else if(logIn.getLevel()==1) {
                   System.out.println("평론가 회원만 평론할 수 있습니다.");
               }
            } else if (choice2 == 3) {
                showMenu();
            }
        } else if (menuChoice == 2) {
            theaterViewer.theaterList();
        } else if (menuChoice == 3) {
            screenViewer.screenList();
        } else if (menuChoice == 4) {
            userViewer.showMenu();
        }
    }
}













