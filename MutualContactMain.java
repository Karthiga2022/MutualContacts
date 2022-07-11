package VidhinSan.MutualContact;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MutualContactMain {

    ArrayList<User> userList=new ArrayList<User>();
    ArrayList<Contacts> contactList =new ArrayList<Contacts>();
    HashMap<Integer,HashMap> hm=new HashMap<Integer,HashMap>();
    HashMap<Integer,String > hm1 = new HashMap<Integer,String >();

    int ch;
    int uid;
    int flag=0;
    int cid;
    Scanner sc=new Scanner(System.in);

    public void addUser() {

        User user = new User(1, "Karthiga", 9840708393l, "devi.karthiga@gmail.com");
        userList.add(user);
        User user1 = new User(2, "Jeyanthi", 9867454676l, "priya@gmail.com");
        userList.add(user1);
        User user2 =new User(3,"Shivani",9840708393l,"shivani@gmail.com");
        userList.add(user2);
    }

    public void addContact() {
        Contacts contact = new Contacts(1, "Nithya");
        contactList.add(contact);
        Contacts contact1 = new Contacts(2, "Brinda");
        contactList.add(contact1);
        Contacts contact2 = new Contacts(3, "Ajay");
        contactList.add(contact2);
        Contacts contact3 = new Contacts(4, "Prathiba");
        contactList.add(contact3);
        Contacts contact4 = new Contacts(5, "Subashini");
        contactList.add(contact4);
        Contacts contact5 = new Contacts(6, "Kaviya");
        contactList.add(contact5);
    }

    public void addUserContact()
    {
        System.out.println("Enter User id : ");
        uid = sc.nextInt();
        for (User list : userList) {
            if (list.getUserID() == uid) {
                flag = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Add Contact");

            System.out.println("Enter Contact Id to map");

            cid = sc.nextInt();

            if(hm.containsKey(uid))
            {


                for(Map.Entry m1 : hm.entrySet())
                {
                    if(m1.getKey()==(Integer)uid)
                    {
                        hm1=(HashMap<Integer, String>) m1.getValue();
                    }

                }
                System.out.println("Contacts");
                System.out.println("---------");
                for (Contacts clist : contactList) {

                    if (clist.getContactID()==cid)
                    {
                        hm1.put(clist.getContactID(),clist.getContactName());
                    }
                    System.out.println(clist.getContactID() + "   " + clist.getContactName());
                    hm.put(uid, hm1);
                }
            }
            else
            {
                hm1=new HashMap<>();

                for (Contacts clist : contactList) {

                    if (clist.getContactID()==cid)
                    {
                        hm1.put(clist.getContactID(),clist.getContactName());
                    }
                    System.out.println(clist.getContactID() + "   " + clist.getContactName());
                    hm.put(uid, hm1);
                }
            }

            System.out.println("List of Mapped Contacts");
            System.out.println("-----------------------");

            for(Map.Entry m1: hm.entrySet())
            {
                System.out.println(m1.getKey()+ "  " +m1.getValue());

            }

        } else {
            System.out.println("User does not exist");
        }
    }

    public void mutualContacts() {
        System.out.println("Enter User Id 1");
        int uid1 = sc.nextInt();
        System.out.println("Enter user id 2");
        int uid2 = sc.nextInt();

        if (hm.containsKey(uid1) && hm.containsKey(uid2)) {

            System.out.println("Mutual Contacts");
            System.out.println("---------------");

            for (Map.Entry m1 : hm.entrySet()) {
                if (m1.getKey() == (Integer) uid1) {
                    hm1 = (HashMap<Integer, String>) m1.getValue();
                    for (Map.Entry m : hm1.entrySet()) {
                     //   System.out.println(m.getValue());
                        String s1 = (String) m.getValue();
                        for (Map.Entry m3 : hm.entrySet()) {
                            if (m3.getKey() == (Integer) uid2) {
                                hm1 = (HashMap<Integer, String>) m3.getValue();
                                for (Map.Entry m4 : hm1.entrySet()) {
                                    if (m.getValue().equals(m4.getValue())) {
                                        System.out.println(m.getValue());
                                    }
                                }
                            }

                        }

                    }

                }
            }
        }
    }

        public void selectOptions() {
            do {
                {
                    System.out.println();
                    System.out.println("Mutual Contacts");
                    System.out.println("-----------------");
                    System.out.println("1.Add Contact");
                    System.out.println("2.Find Mutual Contact");
                    System.out.println("Enter your Option");
                    ch = sc.nextInt();
                    switch (ch) {
                        case 1:
                            addUserContact();
                            break;

                        case 2 :
                            mutualContacts();
                            break;

                    }

                }

            }while(ch!=0);
        }


    public static void main(String[] args) {
        MutualContactMain mutual=new MutualContactMain();
        mutual.addUser();
        mutual.addContact();
        mutual.selectOptions();

    }
}
