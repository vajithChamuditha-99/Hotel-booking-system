import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelMenu {

    private static void addBookingDetails(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter customer's first name      : ");
        String firstName = scan.nextLine();
        System.out.print("Enter customer's second name     : ");
        String secondName = scan.nextLine();
        System.out.print("Enter customer's ID number       : ");
        String cusID = scan.nextLine();
        System.out.print("Enter customer's contact details : ");
        String contactDet = scan.nextLine();

        System.out.print("Enter the Room number (1-20)     : ");
        int roomNum=0;
        try {
            roomNum = scan.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }

        Details details=new Details(firstName,secondName,cusID,contactDet,roomNum);
        Room.addToRoom(details);

        /*if (Room.isEmpty(details)){
            System.out.println("Already booked");
        }else{

        }*/
        //System.out.println(details.getRoomNumber());
    }

    private static void deleteBookingDetails(){
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter room number to delete or -1 to exit - ");
            int deleteMe;
            try {
                deleteMe = input.nextInt()-1;
            } catch (InputMismatchException e) {
                System.out.println("Enter a number");
                continue;
            }
            if (deleteMe==-2) break;
            else if (deleteMe<0 || deleteMe>21){
                System.out.println("Invalid input");
                continue;
            }
            Details details9;
            System.out.println();
            Details details = Room.getRoomDetails()[deleteMe];
            if (details==null){       //check if a customer available to delete
                System.out.println("No customer to delete");
            }else {
                System.out.println(details.getName()+" in "+(details.getRoomNumber())+" confirm(Y/N) ?");
                Scanner temp = new Scanner(System.in);
                String tempString = temp.next();
                if (tempString.equalsIgnoreCase("y")){
                    Room.remove(deleteMe);
                    System.out.println("Record deleted");
                }else System.out.println("Deletion canceled");
            }
        }

    }

    private static void viewCustomers(){
        for (Details details: Room.getRoomDetails()){
            if (details!=null){
                System.out.println(details);
            }
        }
    }

    private static void viewEmptyRooms(){
        for (int i=0;i<20;i++){
            if (Room.getRoomDetails()[i]==null){
                System.out.println("Room number "+ (i+1)+" is Empty");
            }
        }
//        for (Details details: Room.getRoomDetails()){
//            if (Room.isEmpty(details)){
//                System.out.println("Room number "+ details.getRoomNumber()+" is Empty");
//            }
//        }
    }

    private static void findRomNumberFromCustomerId(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID number to search - ");
        String idNumber = sc.nextLine();

        for (Details details :Room.getRoomDetails()){
            if(details.getIdNumber().equals(idNumber)){
                System.out.println(details);
            }
        }
    }

    private static void saveData(){

    }

    private static void loadData(){

    }


    public static void main(String[] args) {
        System.out.println("\n***Welcome to Train Booking System***");
        System.out.println("---------------------------------------");
        menu();

    }

    private static void menu(){
        Scanner scan = new Scanner(System.in);
        menu:
        while (true) {
            System.out.println("\nEnter \"A\" for Book a Room");
            System.out.println("Enter \"V\" for View all Rooms");
            System.out.println("Enter \"E\" for View empty Rooms ");
            System.out.println("Enter \"D\" for Delete customer from Rooms");
            System.out.println("Enter \"F\" for find a Room by Customer Id");
            System.out.println("Enter \"S\" for save data to database");
            System.out.println("Enter \"L\" for get data from the database");
            //System.out.println("Enter \"O\" for View seats Order alphabetically by name");
            System.out.println("Enter \"Q\" for quit");
            System.out.println("---------------------------------------------------");
            System.out.print("Please select your option: ");
            String selection = scan.nextLine();
            System.out.println("");
            selection = selection.toUpperCase(); //convert user input to upper case
            switch (selection) {
                case "A":
                    addBookingDetails();
                    break;
                case "V":
                    viewCustomers();
                    break;
                case "E":
                    viewEmptyRooms();
                    break;
                case "D":
                    deleteBookingDetails();
                    break;
                case "F":
                    findRomNumberFromCustomerId();

                    break;
                case "S":
                    saveData();
                    break;
                case "L":
                    loadData();
                    break;
                case "O":
                    //m
                    break;
                case "Q":
                    System.out.println("---------------------------------------------------");
                    System.out.println("------------------Enjoy the Day--------------------");
                    break menu; //quit from the menu
                default: //if no matching cases run
                    System.out.println("Invalid selection ");
                    break;
            }
        }
    }


}
