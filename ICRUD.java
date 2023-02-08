package CaseStudy;

import java.util.Scanner;

public interface ICRUD {
     void addPhone(Scanner scanner);
     void editPhone(Scanner scanner);
     void delete(Scanner scanner);
     void writeFile();
     void readFile();
     void sortUpByPrice();
     void displayAll();
     void findByID(Scanner scanner);
    int checkExist(Integer id);
     void findByName(Scanner scanner);
     void sortUpByPrice1();
     void deleteAll();
}
