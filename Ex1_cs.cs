// Author: Nishita Naik
// Roll no: 28
// Title: Goa Legislative Assembly
// Start date: 15/07/2024
// Modified Date: 22/07/2024
// Description: The program gives the information about the members of Goa Legistative assemly.
// Class Member contains all the attribute of a member in a asssembly.
// It has a method to display all the information.
// we can also perform crud operation like addinfg updationg and deleting a member.

using System;
using System.Collections.Generic;

class Member
{
    private string name;
    private string cosnsName;
    private int constNo;
    private string position;

    public Member(string name, string cosnsName, int constNo, string position)
    {
        this.name = name;
        this.cosnsName = cosnsName;
        this.constNo = constNo;
        this.position = position;
    }

    public string GetName()
    {
        return name;
    }

    public string GetCosnsName()
    {
        return cosnsName;
    }

    public int GetConstNo()
    {
        return constNo;
    }

    public string GetPosition()
    {
        return position;
    }

    public override string ToString()
    {
        return $"{name} \nConstituency No/Name: {constNo}/{cosnsName}\n";
    }
}

class Ex1_cs
{
    static List<Member> members = new List<Member>();

    static void Main(string[] args)
    {
        members.Add(new Member("Shri. Jit Arolkar", "Mandrem", 01, "MLA Member"));
        members.Add(new Member("Shri. Pravin Arlekar", "Pernem", 02, "MLA Member"));
        members.Add(new Member("Shri. Chandrakant Shetye", "bicholim", 03, "MLA Member"));
        members.Add(new Member("Shri. Nilkanth Halarnkar", "Tivim", 04, "Cabinet Minister"));
        members.Add(new Member("Shri. Joshua De Souza", "Mapusa", 05, "Deputy Speaker"));
        members.Add(new Member("Shri. Rohan Khaunte", "Porvorim", 9, "Cabinet Minister"));
        members.Add(new Member("Shri. Atanasio Monserrate", "Pnaji", 11, "Cabinet Minister"));
        members.Add(new Member("Shri. Pramod Sawant", "Sanquelim", 17, "Chief Minister"));
        members.Add(new Member("Shri. Yuri Alemao", "Cuncolim", 34, "Opposition Leader"));
        members.Add(new Member("Shri. Ramesh Tawadkar", "Cancona", 40, "Speaker"));
        members.Add(new Member("Shri. Nilkanth Halarnkar", "Tivim", 04, "Cabinet Minister"));

        int ch;
        do
        {
            Console.WriteLine("\n\nGOA LEGISLATIVE ASSEMBLY");
            Console.WriteLine("1. The Legislature");
            Console.WriteLine("2. The Government");
            Console.WriteLine("3. MLA's");
            Console.WriteLine("4. Exit");
            Console.Write("Enter your choice: ");
            ch = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("\n");
            switch (ch)
            {
                case 1:
                    Legislature();
                    break;
                case 2:
                    Government();
                    break;
                case 3:
                    MLA();
                    break;
                case 4:
                    Console.WriteLine("-----Exiting-------");
                    break;

                default:
                    Console.WriteLine("please enter valid choice.");
                    break;
            }

        } while (ch != 4);
    }

    public static void MLA()
    {
        int a1;

        do
        {
            Console.WriteLine("\n\n");
            Console.WriteLine("-----------MLA Members---------");
            foreach (Member e in members)
            {
                Console.WriteLine(e);
            }
            Console.WriteLine("\n");

            Console.WriteLine("1. Insert a Member.");
            Console.WriteLine("2. Delete a member");
            Console.WriteLine("3. Update a member");
            Console.WriteLine("4. Exit.");
            Console.Write("enter your choice: ");
            a1 = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("\n");
            switch (a1)
            {
                case 1:
                    Console.Write("enter name: ");
                    string n = Console.ReadLine();
                    Console.Write("enter constituency no: ");
                    int cn = Convert.ToInt32(Console.ReadLine());
                    Console.Write("enter constituency name: ");
                    string cname = Console.ReadLine();
                    members.Add(new Member(n, cname, cn, "MLA Member"));
                    break;

                case 2:
                    bool f = false;
                    Console.Write("enter constituency number of member to delete: ");
                    int no = Convert.ToInt32(Console.ReadLine());
                    members.RemoveAll(e => e.GetConstNo() == no);
                    f = true;
                    if (!f)
                    {
                        Console.WriteLine("member not found");
                    }
                    else
                    {
                        Console.WriteLine("member removed.");
                    }
                    break;

                case 3:
                    bool f2 = false;
                    Console.Write("enter no of constituency to update: ");
                    int no2 = Convert.ToInt32(Console.ReadLine());
                    for (int i = 0; i < members.Count; i++)
                    {
                        if (members[i].GetConstNo() == no2)
                        {
                            Console.Write("enter correct name: ");
                            n = Console.ReadLine();
                            Console.Write("enter correct constituency no: ");
                            cn = Convert.ToInt32(Console.ReadLine());
                            Console.Write("enter correct constituency name: ");
                            cname = Console.ReadLine();
                            members[i] = new Member(n, cname, cn, "MLA Member");
                            f2 = true;
                        }
                    }
                    if (!f2)
                    {
                        Console.WriteLine("member not found");
                    }
                    else
                    {
                        Console.WriteLine("updated successfully.");
                    }
                    break;
                case 4:
                    Console.WriteLine("-----Exiting-------");
                    break;
                default:
                    Console.WriteLine("please enter valid choice.");
                    break;
            }
        } while (a1 != 4);
    }

    public static void Government()
    {
        int choice2;

        do
        {
            Console.WriteLine("\nThe Government");
            Console.WriteLine("1. Governor");
            Console.WriteLine("2. Chief Minister");
            Console.WriteLine("3. Council Of Ministers");
            Console.WriteLine("4. Exit");
            Console.Write("Enter your choice: ");
            choice2 = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("\n");

            switch (choice2)
            {
                case 1:
                    Console.WriteLine("----- The Governor-----");
                    Console.WriteLine("Shri. P. S. Sreedharan Pillai");
                    break;

                case 2:
                    Console.WriteLine("\n----- The Chief Minister-----");
                    foreach (Member e in members)
                    {
                        if (e.GetPosition() == "Chief Minister")
                        {
                            Console.WriteLine(e);
                        }
                    }
                    break;

                case 3:
                    Console.WriteLine("----- The Cabinet Ministers-----");
                    foreach (Member e in members)
                    {
                        if (e.GetPosition() == "Cabinet Minister")
                        {
                            Console.WriteLine(e);
                        }
                    }
                    break;

                case 4:
                    Console.WriteLine("-----Exiting-------");
                    break;

                default:
                    Console.WriteLine("please enter valid choice");
                    break;
            }

        } while (choice2 != 4);
    }

    public static void Legislature()
    {
        int choice;

        do
        {
            Console.WriteLine("GOA LEGISLATURE");
            Console.WriteLine("1. The Speaker");
            Console.WriteLine("2. Deputy Speaker");
            Console.WriteLine("3. Opposition Leader");
            Console.WriteLine("4. Exit");
            Console.Write("Enter your choice: ");
            choice = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("\n");

            switch (choice)
            {
                case 1:
                    Console.WriteLine("----- The Speaker-----");
                    foreach (Member e in members)
                    {
                        if (e.GetPosition() == "Speaker")
                        {
                            Console.WriteLine(e);
                        }
                    }
                    break;

                case 2:
                    Console.WriteLine("----- The Deputy Speaker-----");
                    foreach (Member e in members)
                    {
                        if (e.GetPosition() == "Deputy Speaker")
                        {
                            Console.WriteLine(e);
                        }
                    }
                    break;

                case 3:
                    Console.WriteLine("----- The Leader of Opposition-----");
                    foreach (Member e in members)
                    {
                        if (e.GetPosition() == "Opposition Leader")
                        {
                            Console.WriteLine(e);
                        }
                    }
                    break;

                case 4:
                    Console.WriteLine("-----Exiting-------");
                    break;

                default:
                    Console.WriteLine("please enter valid choice");
                    Console.WriteLine("---------------------------\n");
                    break;
            }

        } while (choice != 4);
    }
}
