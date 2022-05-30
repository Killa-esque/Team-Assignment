import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Zoo zoo = new Zoo("Tho Trang","Quan 10", "./input/Staffs.txt", "./input/Animal.txt","./input/Timekeeping.txt");
        Scanner input = new Scanner(System.in);
        System.out.println(
                "1. List of Staff"
                + "\n2. List of Animal"
                + "\n3. Payment of Trainer"
                + "\n4. Payment of OfficeStaff"
                + "\n5. Assign for Staff"
                + "\n6. Exit"

        );

        int choice = 0;
        do {
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(System.console().readLine());
            switch (choice) {
                case 1:
                    System.out.println("List of Staff");
                    zoo.writeFile("./output/StaffsList.txt", zoo.getStaff());
                    break;
                case 2:
                    System.out.println("List of Animal");
                    zoo.writeFile("./output/AnimalList.txt", zoo.getAnimals());
                    break;
                case 3:
                    System.out.println("Payment of Trainer");
                    ArrayList<Trainer> Req2 = zoo.getTopFiveTrainerHighSalary();
                    zoo.writeFile("./output/SalaryDescending_Trainer.txt", Req2);
                    break;
                case 4:
                    System.out.println("Payment of OfficeStaff");
                    ArrayList<OfficeStaff> Req3 = zoo.getTopFiveOfficeStaffHighSalary();
                    zoo.writeFile("./output/SalaryAscending_OfficeStaff.txt", Req3);
                    break;
                case 5: 
                    System.out.println("Assign for Staff");
                    System.out.println(
                        "Enter random area:"
                        + "\n1. Fish"
                        + "\n2. Bird"
                        + "\n3. Reptile"
                        );

                    String area = input.nextLine();
                    ArrayList<String> Req4 = zoo.assignFor(area);
                    zoo.writeFile("./output/Assign.txt", Req4);
                    break;
                default:
                    System.out.println("The program is ended.");
                    break;
            }
        } while (choice != 0);
        
    }
}
