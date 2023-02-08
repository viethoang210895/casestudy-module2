package CaseStudy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneManager implements Serializable, Comparable<Phone>, ICRUD {
    ArrayList<Phone> phones;

    public PhoneManager() {
        phones = new ArrayList<>();
    }

    public PhoneManager(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public void addPhone(Scanner scanner) {
        if (phones.size()>0) {
            Phone.INDEX = phones.get(phones.size() - 1).getId();
        }
        Pattern p = Pattern.compile("[a-z\\sA-Z]+");
        Pattern p1 = Pattern.compile("[0-9]+");
        String name;
        while (true) {
            System.out.println("    Enter Name :");
            name = scanner.nextLine();
            if (name.matches(String.valueOf(p)) && name != " ") {
                break;
            } else {
                System.err.println("    Name is must be  alphabet !");
            }
        }
        String color;
        while (true) {
            System.out.println("    Enter Color :");
            color = scanner.nextLine();
            if (color.matches(String.valueOf(p)) && color != " ") {
                break;
            } else {
                System.err.println("    Color is must be  alphabet !");
            }
        }
        String country;
        while (true) {
            System.out.println("    Enter Country : ");
            country = scanner.nextLine();
            if (country.matches(String.valueOf(p)) && country != " ") {
                break;
            } else {
                System.err.println("    Country is must be alphabet !");
            }
        }
        String price;
        while (true) {
            System.out.println("    Enter Price :");
            price = scanner.nextLine();
            if (price.matches(String.valueOf(p1)) && price != " ") {
                break;
            } else {
                System.err.println("price is must be number !");
            }
        }
        String amount;
        while (true) {
            System.out.println("    Enter amount");
            amount = scanner.nextLine();
            if (amount.matches(String.valueOf(p1)) && amount != " ") {
                break;
            } else {
                System.err.println("amount is must be number !");
            }
        }

        phones.add(new Phone(name, color, country, Long.parseLong(price), Integer.parseInt(amount)));
        writeFile();
    }

    @Override
    public void editPhone(Scanner scanner) {
        Pattern p = Pattern.compile("[a-z\\sA-Z]+");
        Pattern p1 = Pattern.compile("[0-9]+");

        try {

            System.out.println("    Enter ID you want to edit :");
            Integer idEdit = Integer.parseInt(scanner.nextLine());

            int index;
            if ((index = checkExist(idEdit)) != -1) {
                String name;
                while (true) {
                    System.out.println("    Enter new Name :");
                    name = scanner.nextLine();
                    if (name.matches(String.valueOf(p)) && name != " ") {
                        phones.get(index).setName(name);
                        break;
                    } else {
                        System.err.println("    Name is must be alphabet !");

                    }
                }
                String color;
                while (true) {
                    System.out.println("    Enter new color :");
                    color = scanner.nextLine();
                    if (color.matches(String.valueOf(p)) && color != " ") {
                        phones.get(index).setColor(color);
                        break;
                    } else {
                        System.err.println("color is must be haven an alphabet !");

                    }
                }
                String country;
                while (true) {
                    System.out.println("    Enter new Country :");
                    country = scanner.nextLine();
                    if (country.matches(String.valueOf(p)) && country != " ") {
                        phones.get(index).setCountry(country);
                        break;
                    } else {
                        System.err.println("Country is must be haven an alphabet !");

                    }
                }
                String price;
                while (true) {
                    System.out.println("    Enter new Price :");
                    price = scanner.nextLine();
                    if (price.matches(String.valueOf(p1)) && price != " ") {
                        phones.get(index).setPrice(Long.parseLong(price));
                        break;
                    } else {
                        System.err.println("price is must be number !");
                    }
                }
                String amount;
                while (true) {
                    System.out.println("    Enter new Amount :");
                    amount = scanner.nextLine();
                    if (amount.matches(String.valueOf(p1)) && amount != " ") {
                        phones.get(index).setAmount(Integer.parseInt(amount));
                        break;
                    } else {
                        System.err.println("amount is must be number !");
                    }
                }
                writeFile();
                displayAll();
            }else {
                System.err.println("ID Not Exist!!!");
            }
        } catch (Exception e) {
            System.err.println("Price and Amount must be Long and Integer ");
            System.out.println("Please re-Enter ");
        }
    }

    @Override
    public void delete(Scanner scanner) {
        try {
            System.out.println("    Let Enter ID to delete: ");
            Integer idDelete = Integer.parseInt(scanner.nextLine());
            int index;
            Pattern p2 = Pattern.compile("(?:Y|N)");
            if ((index = checkExist(idDelete)) != -1) {
                String answer;
                while (true) {
                    System.out.println("    Enter Y to delete . N to back MENU ");
                    answer = scanner.nextLine();
                    if (answer.matches(String.valueOf(p2))) {
                        if (answer.equals("Y")) {
                            phones.remove(index);
                            break;
                        } else if (answer.equals("N")) {
                            break;
                        }

                    }
                } writeFile();
            }
        } catch (NumberFormatException e) {
            System.err.println("Information is not Fit");
        }
    }

    @Override
    public int checkExist(Integer id) {
        for (Phone phone : phones) {
            if (phone.getId().equals(id)) {
                return phones.indexOf(phone);
            }
        }
        return -1;
    }

    @Override
    public void findByID(Scanner scanner) {
        try {
            Pattern p1 = Pattern.compile("[0-9]+");
            String check;
            while (true) {
                System.out.println("    Enter ID  : ");
                check = scanner.nextLine();
                if (check.matches(String.valueOf(p1)) && check != " ") {
                    break;
                } else {
                    System.err.println("ID is must be number !");
                }
            }
            int number=0;
            for (Phone phone : phones) {
                if (phone.getId().equals(Integer.parseInt(check))) {
                    System.out.printf("%-10s%-10s%-10s%-10s%-15s%s", phone.getId(), phone.getName(), phone.getColor(), phone.getCountry(), phone.getPrice(), phone.getAmount() + "\n");
                    number++;
                }
            }
            if (number==0){
                System.err.println("Not Exist !!!!");
            }
        } catch (Exception e) {
            System.err.println("Not Exist !!!");
        }
    }

    @Override
    public void findByName(Scanner scanner) {
        try {
            Pattern p = Pattern.compile("[a-z\\sA-Z]+");
            String check;
            while (true) {
                System.out.println("    Enter new Name :");
                check = scanner.nextLine();
                if (check.matches(String.valueOf(p)) && check != " ") {
                    break;
                } else {
                    System.err.println("Name is must be  alphabet ! ");
                }
            }
                int count=0;
            for (Phone phone : phones) {
                if (phone.getName().equals(check)) {
                    System.out.printf("%-10s%-10s%-10s%-10s%-15s%s",
                            phone.getId(), phone.getName(), phone.getColor(), phone.getCountry(), phone.getPrice(), phone.getAmount() + "\n");
                    count++;
                }
            }
            if (count==0){
                System.err.println("Not Exist!!!!");
            }

        } catch (Exception e) {
            System.out.println("Not Exist!!!");
        }
    }

    @Override
    public void writeFile() {
        try {
            File path = new File("src/CaseStudy/phone");
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(phones);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() {
        ArrayList<Phone> phonearrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src/CaseStudy/phone");
            ObjectInputStream ois = new ObjectInputStream(fis);
            phonearrayList = (ArrayList<Phone>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("");
        }
        phones = phonearrayList;
    }

    @Override
    public void displayAll() {
        System.out.printf("%-10s%-10s%-10s%-10s%-15s%-20s%s", "ID", "Name", "Color", "Country", "Price", "Amount", "\n");
        for (Phone phone : phones) {
            System.out.printf("%-10s%-10s%-10s%-10s%-15s%s", phone.getId(), phone.getName(), phone.getColor(), phone.getCountry(), phone.getPrice(), phone.getAmount() + "\n");

        }
    }

    @Override
    public int compareTo(Phone o) {
        return 0;
    }

    @Override
    public void sortUpByPrice() {
        Collections.sort(this.phones, new Comparator<Phone>() {
            @Override
            public int compare(Phone p1, Phone p2) {
                if (p1.getPrice() < p2.getPrice()) {
                    return -1;
                } else if (p1.getPrice() > p2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
    @Override
    public void sortUpByPrice1() {
        Collections.sort(this.phones, new Comparator<Phone>() {
            @Override
            public int compare(Phone p1, Phone p2) {
                if (p1.getPrice() < p2.getPrice()) {
                    return 1;
                } else if (p1.getPrice() > p2.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
    public void deleteAll(){
        phones.clear();
    }
}
