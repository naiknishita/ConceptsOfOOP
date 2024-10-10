// Author: Nishita Naik
// Roll no: 28
// Title: Goa Legislative Assembly
// Start date: 15/07/2024
// Modified Date: 22/07/2024
// Description: The program gives the information about the members of Goa Legistative assemly.
// Class Member contains all the attribute of a member in a asssembly.
// It has a method to display all the information.
// we can also perform crud operation like adding updatiog and deleting a member.

import java.util.*;
class Member{
    private String name;
    private String cosnsName;
    private int constNo;
    private String position;
    
    public Member(String name, String cosnsName, int constNo, String position) {
        this.name = name;
        this.cosnsName = cosnsName;
        this.constNo = constNo;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getCosnsName() {
        return cosnsName;
    }

    public int getConstNo() {
        return constNo;
    }

    public String getPsition(){
        return position;
    }
    public String toString(){
        return name + " \nContituency No/Name: "+constNo+"/"+cosnsName +"\n";
    }
}

class Ex1{ 
    static List<Member> m = new ArrayList<Member>();
    
    public static void main(String[] args){
        
        m.add(new Member("Shri. Jit Arolkar", "Mandrem", 01, "MLA Member"));
        m.add(new Member("Shri. Pravin Arlekar", "Pernem", 02, "MLA Member"));
        m.add(new Member("Shri. Chandrakant Shetye", "bicholim", 03, "MLA Member"));
        m.add(new Member("Shri. Nilkanth Halarnkar", "Tivim", 04, "Cabinet Minister"));
        m.add(new Member("Shri. Joshua De Souza", "Mapusa", 05, "Deputy Speaker"));
        m.add(new Member("Shri. Rohan Khaunte", "Porvorim", 9, "Cabinet Minister"));
        m.add(new Member("Shri. Atanasio Monserrate", "Pnaji", 11, "Cabinet Minister"));
        m.add(new Member("Shri. Pramod Sawant", "Sanquelim", 17, "Chief Minister"));
        m.add(new Member("Shri. Yuri Alemao", "Cuncolim", 34, "Opposition Leader"));
        m.add(new Member("Shri. Ramesh Tawadkar", "Cancona", 40, "Speaker"));
        m.add(new Member("Shri. Nilkanth Halarnkar", "Tivim", 04, "Cabinet Minister"));


        Scanner s = new Scanner(System.in);
        int ch;
        do{
            System.out.println("\n \nGOA LEGISLATIVE ASSEMBLY");
            System.out.println("1. The Legislature");
            System.out.println("2. The Government");
            System.out.println("3. MLA's");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            ch = s.nextInt();
            System.out.println("\n");
            switch (ch) {
                case 1:Legislature();
                    break;
                case 2:Government();
                    break;
                case 3:MLA();                   
                    break;
                case 4:
                    System.out.println("-----Exiting-------");
                    break;
            
                default:System.out.println("please enter valid choice.");
                    break;
            }

        }while(ch!=4);

    }

    public static void MLA(){

        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        int a1;

        do{
            System.out.println("\n\n");
            System.out.println("-----------MLA Members---------");
            Iterator<Member> i = m.iterator();
            while (i.hasNext()) {
                Member e = i.next();
                System.out.println(e);
                
            }
            
            System.out.println("\n");

            System.out.println("1. Insert a Member.");
            System.out.println("2. Delete a member");
            System.out.println("3. Update a member");
            System.out.println("4. Exit.");
            System.out.println("enter your choice: ");
            a1 = a.nextInt();
            System.out.println("\n");
            switch (a1) {
                case 1:
                    System.out.println("enter name: ");
                    String n = b.nextLine();
                    System.out.println("enter constituency no: ");
                    int cn= a.nextInt();
                    System.out.println("enter constituency name");
                    String cname= b.nextLine();
                    m.add(new Member(n, cname, cn,"MLA Member"));
                    break;

                case 2: 
                    boolean f = false;
                    System.out.println("enter constituency number of member to delete : ");
                    int no= a.nextInt();
                    Iterator<Member> j = m.iterator();
                    while(j.hasNext()) {
                        Member e = j.next();
                        if(e.getConstNo() == no) {
                            j.remove();
                            f=true;
                        } 
                    }
                    if (!f){
                        System.out.println("member not found");

                    }else{
                        System.out.println("member removed.");
                    }
                    break;

                case 3:
                    boolean f2 = false;
                    System.out.println("enter no of constituency to update : ");
                    int no2 = a.nextInt();
                    ListIterator<Member> j2 = m.listIterator();
                    while(j2.hasNext()) {
                        Member e = j2.next();
                        if(e.getConstNo()==no2) {
                            System.out.println("enter correct name: ");
                            n = b.nextLine();
                            System.out.println("enter correct constituency no: ");
                            cn= a.nextInt();
                            System.out.println("enter correnct constituency name: ");
                            cname= b.nextLine();
                            j2.set(new Member(n, cname, cn, "MLA Member"));
                            f=true;
                    } 
                }
                if (!f2){
                    System.out.println("member not found");

                }else{
                    System.out.println("updated successfully.");
                }
                    break;
                case 4:
                    System.out.println("-----Exiting-------");
                    break;
                default:
                    System.out.println("please enter valid choice.");
                    break;
            }
        }
        while(a1 != 4);

    }

    public static void Government(){
        Scanner scanner2 = new Scanner(System.in);
        int choice2;

        do {
            System.out.println("\nThe Government");
            System.out.println("1. Governor");
            System.out.println("2. Chief Ministerr");
            System.out.println("3. Council Of Ministers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice2 = scanner2.nextInt();
            System.out.println("\n");

            switch (choice2) {
                case 1:
                    System.out.println("----- The Governor-----");
                    System.out.println("Shri. P. S. Sreedharan Pillai");
                    break;

                case 2:
                    System.out.println("\n----- The Chief Minister-----");
                    Iterator<Member>i= m.iterator();
                    while (i.hasNext()) {
                        Member e = i.next();
                        if(e.getPsition()=="Chief Minister"){
                            System.out.println(e);
                        }    
                    }
                    break;

                case 3:
                    System.out.println("----- The Cabinet Ministers-----");
                    Iterator<Member>k= m.iterator();
                    while (k.hasNext()) {
                        Member e = k.next();
                        if(e.getPsition()=="Cabinet Minister"){
                            System.out.println(e);
                        }    
                    }
                    break;
                    
                case 4:
                    System.out.println("-----Exiting-------");

                    break;

                default:
                    System.out.println("please enter valid choice");
                    break;
            }



        }while(choice2 != 4);

    }

    public static void Legislature(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        Iterator<Member> i = m.iterator();

        do {
            System.out.println("GOA LEGISLATURE");
            System.out.println("1. The Speaker");
            System.out.println("2. Deputy Speaker");
            System.out.println("3. Opposition Leader");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.println("\n");
            
            switch (choice) {
                case 1:
                    System.out.println("----- The Speaker-----");
                    i= m.iterator();
                    while (i.hasNext()) {
                        Member e = i.next();
                        if(e.getPsition()=="Speaker"){
                            System.out.println(e);
                        }    
                    }
                    break;
            
                    case 2:
                    System.out.println("----- The Deputy Speaker-----");
                    i= m.iterator();
                    while (i.hasNext()) {
                        Member e = i.next();
                        if(e.getPsition()=="Deputy Speaker"){
                            System.out.println(e);
                        }    
                    }
                    break;

                    case 3:
                    System.out.println("----- The Leader of Opposition-----");
                    i= m.iterator();
                    while (i.hasNext()) {
                        Member e = i.next();
                        if(e.getPsition()=="Opposition Leader"){
                            System.out.println(e);
                        }    
                    }
                    break;

                case 4:
                    System.out.println("-----Exiting-------");
                    break;
                default:
                    System.out.println("please enter valid choice");
                    System.out.println("---------------------------\n");
                    break;
            }
    
        }while(choice != 4);
    }


    
}