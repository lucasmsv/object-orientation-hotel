package Main;

import Classes.Client;
import Classes.Dices;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dices dices = new Dices();
        Client client;

        byte option=' ';
        String name, email;
        int roomNumber;

        do
        {
            try
            {
                System.out.println("[ Select one option ]");
                System.out.println("\t[1] Customer Entry");
                System.out.println("\t[2] Customer Exit");
                System.out.println("\t[3] View Rooms");
                System.out.println("\t[0] Exit");
                System.out.print("Option: ");
                option = Byte.parseByte(sc.nextLine());

                try
                {
                    switch (option)
                    {
                        case 1:
                            System.out.print("\nName: ");
                            name = sc.nextLine();
                            System.out.print("E-mail: ");
                            email = sc.nextLine();
                            System.out.print("Room number: ");
                            roomNumber = Integer.parseInt(sc.nextLine());
                            roomNumber -= 1;
                            client = new Client(name, email);
                            dices.addClient(client, roomNumber);
                        break;

                        case 2:
                            System.out.print("\nRoom number: ");
                            roomNumber = Integer.parseInt(sc.nextLine());
                            roomNumber -= 1;
                            dices.exitClient(roomNumber);
                        break;

                        case 3:
                            dices.viewRooms();
                        break;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("\n\t[ Entered value is not a number ]\n");
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("\n\t[ Invalid value ]\n");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("\n\t[ Entered value is not a number ]\n");
            }
        }
        while (option != 0);

        sc.close();
    }
}