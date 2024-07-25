
package com.mycompany.demo1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class FashionShop {

    public static void main(String[] args) {
        printmain();
    }

    public static int count = 0;
    public static Scanner sc = new Scanner(System.in);
    public static String[] orderID = new String[0];
    public static String[] phonenum = new String[0];
    public static String[] coustermerID = new String[0];
    public static String[] Size = new String[0];
    public static String[] Status = {"Processing", "Processing", "Processing"};
    public static int[] QTY = new int[0];
    public static double[] Amount = new double[0];
    public static String[] status = {"Processing", "Delivering", "Deliverd"};

    public static final double[] price = {600.00, 800.00, 900.00, 1000.00, 1100.00, 1200.00};

    static void extendArrays() {
        String[] tempOrderID = new String[orderID.length + 1];
        String[] tempCoustomerID = new String[orderID.length + 1];
        String[] tempSize = new String[orderID.length + 1];
        String[] tempphonenum = new String[orderID.length + 1];
        int[] tempQTY = new int[orderID.length + 1];
        double[] tempAmount = new double[orderID.length + 1];
        String[] tempStatus = new String[orderID.length + 1];

        for (int i = 0; i < orderID.length; i++) {
            tempOrderID[i] = orderID[i];
            tempCoustomerID[i] = coustermerID[i];
            tempSize[i] = Size[i];
            tempQTY[i] = QTY[i];
            tempphonenum[i] = phonenum[i];
            tempAmount[i] = Amount[i];
            tempStatus[i] = Status[i];

        }

        orderID = tempOrderID;
        coustermerID = tempCoustomerID;
        Size = tempSize;
        QTY = tempQTY;
        phonenum = tempphonenum;
        Amount = tempAmount;
        Status = tempStatus;

    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    static void printmain() {
        System.out.println("     /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                                    ");
        System.out.println("    | $$_____/                | $$      |__/                           /$$__  $$| $$                                    ");
        System.out.println("    | $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$          ");
        System.out.println("    | $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$          ");
        System.out.println("    | $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$   ");
        System.out.println("    | $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$        ");
        System.out.println("    | $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/          ");
        System.out.println("    |__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/       ");
        System.out.println("                                                                                                    | $$                ");
        System.out.println("                                                                                                    | $$                ");
        System.out.println("                                                                                                    |__/                ");
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------   ");
        System.out.println(" ");
        System.out.println("           [01] Place Order                                           [02] Search Customer       \n");
        System.out.println("           [03] Search Order                                          [04] View Reports          \n");
        System.out.println("           [05] Change Order Status                                   [06] Delete Order          \n");

        Scanner obj = new Scanner(System.in);
        System.out.print("Input Option : ");
        char Input = obj.next().charAt(0);
        switch (Input) {
            case '1':
                PlaceOrder();
                break;
            case '2':
                SearchCustomer();
                break;
            case '3':
                searchOrder();
                break;
            case '6':
                deleteOrder();
                break;

        }

    }

    static void PlaceOrder() {
        count++;

        System.out.println("   _____  _                   ____          _                   ");
        System.out.println("  |  __ \\| |                 / __ \\        | |                ");
        System.out.println("  | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __         ");
        System.out.println("  |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|      ");
        System.out.println("  | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |           ");
        System.out.println("  |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|     ");
        System.out.println("_______________________________________________________       \n");

        System.out.println(" ");
        System.out.printf("Order ID %2s%4s%05d%n", ": ", "ODR#", count);
        String orderid = "ODR#" + String.format("%05d", count);
        L1:
        while (true) {

            System.out.print("\nEnter Customer Phone Number : ");
            String phonenumber = sc.next();
            if (phonenumber.matches("0\\d{9}")) {
                L2:
                while (true) {
                    System.out.print("\nEnter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
                    String size = sc.next().toUpperCase();
                    if (size.equals("XXL") || size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL")) {
                        L3:
                        while (true) {
                            System.out.print("\nEnter the qty : ");
                            int qty = sc.nextInt();
                            if (qty < 0) {
                                continue;
                            } else {
                                double amount = 0;
                                switch (size) {
                                    case "XS" ->
                                        amount = qty * price[0];
                                    case "S" ->
                                        amount = qty * price[1];
                                    case "M" ->
                                        amount = qty * price[2];
                                    case "L" ->
                                        amount = qty * price[3];
                                    case "XL" ->
                                        amount = qty * price[4];
                                    case "XXL" ->
                                        amount = qty * price[5];
                                }
                                System.out.printf("\nAmount %2s%.2f", ": ", amount);
                                System.out.println(" ");
                                System.out.println("\nDo You Want to Palce This Order (Y/N) : ");
                                char A = sc.next().charAt(0);
                                if (A == 'Y' || A == 'y') {
                                    System.out.println("\nOredr Placed...");
                                    extendArrays();
                                    orderID[orderID.length - 1] = orderid;
                                    phonenum[orderID.length - 1] = phonenumber;
                                    Size[orderID.length - 1] = size;
                                    QTY[orderID.length - 1] = qty;
                                    Amount[orderID.length - 1] = amount;
                                    Status[orderID.length - 1] = status[0];

                                    System.out.print("\nDo You want to Place another Order (Y/N) : ");
                                    char B = sc.next().charAt(0);
                                    if (B == 'Y' || B == 'y') {
                                        clearConsole();
                                        PlaceOrder();
                                    } else if (B == 'N' || B == 'n') {
                                        clearConsole();
                                        printmain();
                                    }

                                } else if (A == 'N' || A == 'n') {
                                    count--;
                                    clearConsole();
                                    printmain();
                                }

                            }

                        }
                    } else {
                        System.out.println("size ");
                        continue L2;
                    }

                }

            } else {
                System.out.println("\n\tInvalid Phone number... Try again");
                System.out.print("\nDo you want to enter the correct Number again (Y/N) : ");
                char An = sc.next().charAt(0);
                if (An == 'Y' || An == 'y') {
                    continue L1;
                } else if (An == 'N' || An == 'n') {
                    count--;
                    printmain();

                }
            }
        }

    }

    static void SearchCustomer() {

        System.out.println("    _____                     _        _____          _                            ");
        System.out.println("   / ____|                   | |      / ____|        | |                           ");
        System.out.println("  | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
        System.out.println("   \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
        System.out.println("   ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
        System.out.println("  |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");
        System.out.println("____________________________________________________________________________________");
        System.out.println("");

        System.out.print("\nEnter Customer Phone Number : ");
        String phonenumber = sc.next();
        int temp[] = new int[phonenum.length];
        int count1 = 0;
        int XScount = 0;
        int Scount = 0;
        int Mcount = 0;
        int Lcount = 0;
        int XLcount = 0;
        int XXLcount = 0;
        for (int i = 0; i < phonenum.length; i++) {
            if (phonenum[i].equals(phonenumber)) {
                switch (Size[i]) {
                    case "XS":
                        XScount += QTY[i];
                        break;
                    case "S":
                        Scount += QTY[i];
                        break;
                    case "M":
                        Mcount += QTY[i];
                        break;
                    case "L":
                        Lcount += QTY[i];
                        break;
                    case "XL":
                        XLcount += QTY[i];
                        break;
                    case "XXL":
                        XXLcount += QTY[i];
                        break;

                }
            }
        }

        String sizeTemp[] = {"XS", "S", "M", "L", "XL", "XXL"};
        int[] qty = {XScount, Scount, Mcount, Lcount, XLcount, XXLcount};
        double[] total = {XScount * 600, Scount * 800, Mcount * 900, Lcount * 1000, XLcount * 1100, XXLcount * 1200};
        double totAmount = total[0] + total[1] + total[2] + total[3] + total[4] + total[5];

        System.out.println("\nSize\tQTY\tAmount");

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        for (int i = 0; i < sizeTemp.length; i++) {
            System.out.println(sizeTemp[i] + "\t" + qty[i] + "\t" + decimalFormat.format(total[i]));

        }
        System.out.println("   Total Amount      |  " + totAmount);
        while (true) {
            System.out.print("\nDo you want to search another Coustomer report? (y/n) : ");
            String yn3 = sc.next().toLowerCase();

            if (yn3.equals("y")) {
                clearConsole();
                SearchCustomer();
            } else if (yn3.equals("n")) {
                clearConsole();
                printmain();
            } else {
                System.out.println("\t\tInvalid Input..");
                clearConsole();
                SearchCustomer();
            }
        }

    }

    static void searchOrder() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t   _____                     _        ____          _           
                                \t / ____|                   | |      / __ \\        | |          
                                \t| (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ 
                                \t \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|
                                \t ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   
                               \t|_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   """);

            System.out.println(
                    "\t_____________________________________________________________");
            System.out.println("");
            System.out.println("");

            System.out.print("\tEnter order ID : ");
            String orderIDno = sc.next();
            System.out.println("");

            int orderIDIndex = -1;
            if (orderIDno.matches("ODR#\\d+") && orderIDno.length() == 9) {
                for (int i = 0; i < orderID.length; i++) {
                    if (orderIDno.equalsIgnoreCase(orderID[i])) {
                        orderIDIndex = i;
                    }
                }

                if (orderIDIndex > -1) {
                    System.out.println("Phone Number : " + phonenum[orderIDIndex]);
                    System.out.println("Size : " + Size[orderIDIndex]);
                    System.out.println("QTY : " + QTY[orderIDIndex]);
                    System.out.println("Amount : " + Amount[orderIDIndex]);
                    System.out.println("Status : " + Status[orderIDIndex]);

                    System.out.println("");
                    System.out.println("");

                } else {
                    System.out.println("\t\tInvalid ID 1...");
                    System.out.println("");

                }

            } else {
                System.out.println("\t\tInvalid ID 2...");
                System.out.println("");

            }
            while (true) {
                System.out.print("\tDo you want to search another order ? (Y/N) : ");
                String SearchAnotherOrderYN = sc.next();

                if (SearchAnotherOrderYN.equalsIgnoreCase("y")) {
                    searchOrder();
                } else if (SearchAnotherOrderYN.equalsIgnoreCase("n")) {
                    printmain();
                }
            }
        }
    }

    public static void reports() {

        System.out.println(" ");
        System.out.println("   _____                       _                ");
        System.out.println("  |  __ \\                     | |              ");
        System.out.println("  | |__) |___ _ __   ___  _ __| |_ ___          ");
        System.out.println("  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|      ");
        System.out.println("  | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\     ");
        System.out.println("  |_|  \\_\\___| .__/ \\___/|_|   \\__|___/     ");
        System.out.println("             | |                                ");
        System.out.println("             |_|                                ");
        System.out.println("________________________________________      \n");

        System.out.printf("\t\t%-25s%n\n\t\t%-25s%n\n\t\t%-25s%n", "[1] Coustomer Reports ", "[2] Item Reports ", "[3] Orders Reports ");

        System.out.print("\nEnter option : ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                coustomersReports();
                break;
            case 2:
                clearConsole();
                itemReports();
                break;
            case 3:
                clearConsole();
                orderReports();
                break;
        }

    }

    public static void coustomersReports() {

        System.out.println(" ");
        System.out.println("    _____          _                              _____                       _                 ");
        System.out.println("   / ____|        | |                            |  __ \\                     | |               ");
        System.out.println("  | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___           ");
        System.out.println("  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|    ");
        System.out.println("  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\    ");
        System.out.println("   \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/ ");
        System.out.println("                                                            | |                                 ");
        System.out.println("                                                            |_|                                 ");
        System.out.println("___________________________________________________________________________________________   \n");

        System.out.printf("\t\t%-25s%n\n\t\t%-25s%n\n\t\t%-25s%n", "[1] Best in Coustomers ", "[2] View Coustomers ", "[3] All Coustomer Report ");

        System.out.print("\nEnter option : ");
        int option1 = sc.nextInt();

        switch (option1) {
            case 1:
                clearConsole();
                bestInCoustomers();
                break;
            case 2:
                clearConsole();
                viewCoustomers();
                break;
            case 3:
                clearConsole();
                allCoustomerReport();
                break;
        }
    }

    static void deleteOrder() {
        while (true) {
            clearConsole();
            System.out.println("""
                               \t  _____       _      _          ____          _           
                               \t |  __ \\     | |    | |        / __ \\        | |          
                               \t | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ 
                               \t | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|
                               \t | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   
                               \t |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   """);
            System.out.println("\n\t_____________________________________________________\n");
            System.out.print("\tEnter order ID : ");
            String orderIDno = sc.next();
            System.out.println("");

            int orderIDIndex = -1;
            if (orderIDno.matches("ODR#\\d+") && orderIDno.length() == 9) {
                for (int i = 0; i < FashionShop.orderID.length; i++) {
                    if (orderIDno.equalsIgnoreCase(FashionShop.orderID[i])) {
                        orderIDIndex = i;
                    }
                }

                if (orderIDIndex > -1) {
                    System.out.println("Phone Number : " + phonenum[orderIDIndex]);
                    System.out.println("T-Shirt Size : " + Size[orderIDIndex]);
                    System.out.println("QTY : " + QTY[orderIDIndex]);
                    System.out.println("Amount : " + Amount[orderIDIndex]);
                    System.out.println("Status : " + Status[orderIDIndex]);
                    L1:
                    while (true) {
                        System.out.print("\tDo you want to delete this order ? (Y/N) : ");
                        String input = sc.next();
                        switch (input.toLowerCase()) {
                            case "y" -> {
                                orderID = removeValue(orderID, orderIDIndex);
                                QTY = removeValue(QTY, orderIDIndex);
                                phonenum = removeValue(phonenum, orderIDIndex);
                                Amount = removeValue(Amount, orderIDIndex);
                                Status = removeValue(Status, orderIDIndex);
                                Size = removeValue(Size, orderIDIndex);
                                System.out.println("\n\t\tOrder Deleted...!\n");
                                break L1;
                            }
                            case "n" -> {
                                break L1;
                            }
                            default -> {
                                clearConsole();
                                continue L1;
                            }
                        }
                    }

                } else {
                    System.out.println("\n\t\tInvalid ID...");
                    System.out.println("");
                }
                System.out.println("");
                while (true) {
                    System.out.print("\tDo you want to delete another order ? (Y/N) : ");
                    String SearchAnotherOrderYN = sc.next();

                    if (SearchAnotherOrderYN.equalsIgnoreCase("y")) {
                        deleteOrder();
                    } else if (SearchAnotherOrderYN.equalsIgnoreCase("n")) {
                        printmain();
                    } else {
                        clearConsole();
                    }
                }
            } else {
                System.out.println("\t\tInvalid ID...");
                System.out.println("");
                System.out.println("");
                while (true) {
                    System.out.print("\tDo you want to delete another order ? (Y/N) : ");
                    String SearchAnotherOrderYN = sc.next();

                    if (SearchAnotherOrderYN.equalsIgnoreCase("y")) {
                        deleteOrder();
                    } else if (SearchAnotherOrderYN.equalsIgnoreCase("n")) {
                        printmain();
                    } else {
                        clearConsole();
                    }
                }

            }
        }
    }

    static int[] removeValue(int[] arr, int index) {
        int[] tempArr = new int[arr.length - 1];

        for (int i = 0; i < tempArr.length; i++) {
            if (i < index) {
                tempArr[i] = arr[i];
            } else {
                tempArr[i] = arr[i + 1];
            }
        }
        return tempArr;

    }

    static String[] removeValue(String[] arr, int index) {
        String[] tempArr = new String[arr.length - 1];

        for (int i = 0; i < tempArr.length; i++) {
            if (i < index) {
                tempArr[i] = arr[i];
            } else {
                tempArr[i] = arr[i + 1];
            }
        }
        return tempArr;

    }

    static double[] removeValue(double[] arr, int index) {
        double[] tempArr = new double[arr.length - 1];

        for (int i = 0; i < tempArr.length; i++) {
            if (i < index) {
                tempArr[i] = arr[i];
            } else {
                tempArr[i] = arr[i + 1];
            }
        }
        return tempArr;

    }

}
