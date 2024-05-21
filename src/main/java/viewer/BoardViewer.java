package viewer;


import controller.MovieController;
import controller.UserController;
import lombok.Setter;
import model.MovieDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class BoardViewer {

    @Setter
    private UserController userController;
    @Setter
    private Scanner scanner;
    @Setter
    private UserDTO logIn;
    @Setter
    private UserViewer userViewer;
    @Setter
    private MovieController movieController;
    @Setter
    private MovieDTO movieDTO;


    public void adminMenu1() {
        String message = "1. 영화 등록 2. 영화 수정 3. 영화 삭제 4. 뒤로가기";
        int menuChoice = ScannerUtil.nextInt(scanner, message);
        if(menuChoice == 1){
            addMovie();
        }else if(menuChoice ==2){

        }else if(menuChoice ==3){

        }else if(menuChoice ==4){

        }
    }

    public void adminMenu2() {
        String message = "1. 극장 등록 2. 극장 수정 3. 극장 삭제 4. 뒤로가기";
        int menuChoice = ScannerUtil.nextInt(scanner, message);
        if(menuChoice == 1){

        }else if(menuChoice ==2){

        }else if(menuChoice ==3){

        }else if(menuChoice ==4){

        }

    }


    public void addMovie() {
        MovieDTO movieDTO = new MovieDTO();


        String message = "영화 제목을 입력하세요:";
        movieDTO.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "영화 줄거리를 입력하세요:";
        movieDTO.setContent(ScannerUtil.nextLine(scanner, message));

        message = "영화 등급을 입력하세요:";
        movieDTO.setLevel(ScannerUtil.nextInt(scanner, message));

        movieController.addMovie(movieDTO);
        System.out.println("영화가 성공적으로 등록되었습니다.");
    }


}













