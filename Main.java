package CaseStudy;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneManager manager = new PhoneManager();

        while (true) {
            System.out.println("   --------------ＬＯＧ•ＩＮ--------------");
            System.out.println("              --ＡＣＣＯＵＮＴ-- ");
            String id = scanner.nextLine();
            System.out.println("              --ＰＡＳＳＷＯＲＤ--");
            String pass = scanner.nextLine();

            if (id.equals("yahoo") && pass.equals("999999")) {
                try {
                    manager.readFile();
                } catch (Exception e) {
                    System.out.println("");
                }
                System.out.println("---ＷＥＬＣＯＭＥ TＯ ＰＲＯＤＵＣＴ ＭＡＮＡＧＥＲ---");
                do {
                    System.out.println("_________________Ｍ-Ｅ-Ｎ-Ｕ____________________");
                    System.out.println("✎﹏[1]. Add Phone                             ┊");
                    System.out.println("✎﹏[2]. Edit By ID                            ┊");
                    System.out.println("✎﹏[3]. Delete by ID                          ┊");
                    System.out.println("✎﹏[4]. Display                               ┊");
                    System.out.println("✎﹏[5]. Search by ID                          ┊");
                    System.out.println("✎﹏[6]. Search by  Name                       ┊");
                    System.out.println("✎﹏[7]. Sort up ascending by Price >>         ┊");
                    System.out.println("✎﹏[8]. Sort up decrease by Price <<          ┊");
                    System.out.println("✎﹏[9]. Clear All                             ┊");
                    System.out.println("✎﹏ Save data into File  And                  ┊");
                    System.out.println(" Take data from File Are Automatic            ┊");
                    System.out.println("✎﹏[0]. LogOut________________________________┊");
                    System.out.println("Enter Your Selection : ");
                    int choice = -1;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.err.print("");
                    }
                    switch (choice) {
                        case 1:
                            manager.addPhone(scanner);
                            break;
                        case 2:
                            manager.editPhone(scanner);
                            break;
                        case 3:
                            manager.delete(scanner);
                            break;
                        case 4:
                            manager.displayAll();
                            break;
                        case 5:
                            manager.findByID(scanner);
                            break;
                        case 6:
                            manager.findByName(scanner);
                            break;
                        case 7:
                            manager.sortUpByPrice();
                            manager.displayAll();
                            break;
                        case 8:
                            manager.sortUpByPrice1();
                            manager.displayAll();
                            break;
                        case 9:
                            manager.deleteAll();
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            System.err.println("ERROR!! Please again! ");
                    }
                } while (true);
            } else {
                System.err.println("Warnning!!!****Not Match****");
            }
        }
    }
}
