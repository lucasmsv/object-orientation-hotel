package Classes;

public class Dices {

    int counter = 0, limit = 3;
    Client[] bedrooms = new Client[limit];

    public Dices()
    {
        for (int i = 0; i < bedrooms.length; i++)
        {
            bedrooms[i] = new Client();
            bedrooms[i].setStatus("Liberated");
            bedrooms[i].setName("");
            bedrooms[i].setEmail("");
        }
    }

    public void addClient(Client client, Integer roomNumber)
    {
        if (counter == limit)
        {
            System.out.println("\n\t[ All rooms are occupied ]\n");
        }
        else
        {
            if (bedrooms[roomNumber].getStatus().equalsIgnoreCase("Liberated"))
            {
                counter++;
                bedrooms[roomNumber] = client;
                bedrooms[roomNumber].setStatus("Occupied");
                System.out.println("\n\t[ Customer "+ client.getName()+ " is now staying in room "+ (roomNumber+1)+ " ]\n");
            }
            else if (bedrooms[roomNumber].getStatus().equalsIgnoreCase("Occupied"))
            {
                System.out.println("\n\t[ Room "+ (roomNumber+1)+ " already occupied ]\n");
            }
        }
    }

    public void exitClient(Integer roomNumber)
    {
        if (bedrooms[roomNumber].getStatus().equalsIgnoreCase("Occupied"))
        {
            counter--;
            bedrooms[roomNumber].setStatus("Liberated");
            bedrooms[roomNumber].setName("");
            bedrooms[roomNumber].setEmail("");
            System.out.println("\n\t[ Customer removed from system ]\n");
        }
        else
        {
            System.out.println("\n\t[ Room is already free ]\n");
        }
    }

    public void viewRooms()
    {
        System.out.println("\n[ Room Status ]");
        for (int i = 0; i < bedrooms.length; i++)
        {
            System.out.println("\t[Room "+ (i+1)+ "]");
            System.out.println("\t Status: "+ bedrooms[i].getStatus());
            System.out.println("\t Name: "+ bedrooms[i].getName());
            System.out.println("\t E-mail: "+ bedrooms[i].getEmail());
            System.out.println();
        }
    }

}
