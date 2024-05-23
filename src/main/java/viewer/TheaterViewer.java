package viewer;

import controller.TheaterController;
import lombok.Setter;
import model.MovieDTO;
import model.TheaterDTO;
import org.w3c.dom.ls.LSOutput;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class TheaterViewer {

    @Setter
    TheaterDTO theaterDTO;
    @Setter
    TheaterViewer theaterViewer;
    @Setter
    TheaterController theaterController;
    @Setter
    Scanner scanner = new Scanner(System.in);

    public void addTheater() {
        TheaterDTO theaterDTO = new TheaterDTO();

        String message = "극장 이름을 입력하세요";
        theaterDTO.setName(ScannerUtil.nextLine(scanner, message));

        message = "극장 위치를 입력하세요";
        theaterDTO.setLocate(ScannerUtil.nextLine(scanner, message));

        message = "극장 전화번호를 입력하세요";
        theaterDTO.setNum(ScannerUtil.nextLine(scanner, message));

        theaterController.addTheater(theaterDTO);
        System.out.println("새로운 극장이 추가되었습니다.");
    }

    public void modifyTheater() {
        System.out.println("극장 리스트");
        theaterList();

        String message = "상세보기할 극장 번호를 선택하세요 / 0으로 뒤로가기 ";
        int choice = ScannerUtil.nextInt(scanner, message);
        printOne(choice);
    }

    public void theaterList() {
        ArrayList<TheaterDTO> list = (ArrayList<TheaterDTO>) theaterController.selectAll();
        for (TheaterDTO t : list) {
            System.out.printf("%d. %s (%s)\n", t.getId(), t.getName(), t.getLocate());
        }


    }

    private void printOne(int id) {
        TheaterDTO theaterDTO = theaterController.selectOne(id);
        System.out.println("찾은 극장: " + theaterDTO); // 로그 추가
        if (theaterDTO == null) {
            System.out.println("해당 ID의 극장을 찾을 수 없습니다.");
            return;
        }
        System.out.println("==============================");
        System.out.println("ID" + theaterDTO.getId());
        System.out.println("이름 : " + theaterDTO.getName());
        System.out.println("위치: " + theaterDTO.getLocate());
        System.out.println("전화번호 : " + theaterDTO.getNum());
        System.out.println("--------------------------------");
        if (theaterDTO.getId() == theaterDTO.getId()) {
            String message = "1. 수정 2. 삭제 3. 뒤로가기";
            int choice = ScannerUtil.nextInt(scanner, message);
            if (choice == 1) {
                update(theaterDTO);
            } else if (choice == 2) {
                delete(id);
            } else if (choice == 3) {
                modifyTheater();
            }
        }
    }

    public void update(TheaterDTO theaterDTO) {
        String message = "수정된 극장이름을 입력해주세요";
        String newName = ScannerUtil.nextLine(scanner, message);
        theaterDTO.setName(newName);

        message = "수정된 극장 위치를 입력해주세요";
        String newLocate = ScannerUtil.nextLine(scanner, message);
        theaterDTO.setLocate(newLocate);

        message = "수정된 극장 전화번호를 입력해주세요";
        String newNum = ScannerUtil.nextLine(scanner, message);
        theaterDTO.setNum(newNum);

        theaterController.update(theaterDTO);
    }

    public void delete(int id) {
        String message = "정말 삭제하시겠습니까? Y/N";
        String confirm = ScannerUtil.nextLine(scanner, message);
        if (confirm.equalsIgnoreCase("Y")) {
            theaterController.delete(id);
            System.out.println("삭제되었습니다");
            theaterList();

        } else {
            printOne(id);
        }
    }

    public void userPrintOne(int id) {
        TheaterDTO theaterDTO = theaterController.selectOne(id);
        System.out.println("찾은 극장: " + theaterDTO); // 로그 추가
        if (theaterDTO == null) {
            System.out.println("해당 ID의 극장을 찾을 수 없습니다.");
            return;
        }
        System.out.println("==============================");
        System.out.println("ID" + theaterDTO.getId());
        System.out.println("이름 : " + theaterDTO.getName());
        System.out.println("위치: " + theaterDTO.getLocate());
        System.out.println("전화번호 : " + theaterDTO.getNum());
        System.out.println("--------------------------------");

    }
}

