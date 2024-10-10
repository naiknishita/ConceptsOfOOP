'''Author: Nishita Naik
Roll no: 28
Title: Goa Legislative Assembly
Start date: 15/07/2024
Modified Date: 22/07/2024
Description: The program gives the information about the members of Goa Legistative assemly.
Class Member contains all the attribute of a member in a asssembly.
It has a method to display all the information.
we can also perform crud operation like addinfg updationg and deleting a member.'''


class Member:
    def __init__(self, name, cosns_name, const_no, position):
        self.name = name
        self.cosns_name = cosns_name
        self.const_no = const_no
        self.position = position

    def get_name(self):
        return self.name

    def get_cosns_name(self):
        return self.cosns_name

    def get_const_no(self):
        return self.const_no

    def get_position(self):
        return self.position

    def __str__(self):
        return f"{self.name} \nConstituency No/Name: {self.const_no}/{self.cosns_name}\n"

m = []

def MLA():
    #import sys
    #a1 = 0

    while True:
        print("\n\n")
        print("-----------MLA Members---------")
        for e in m:
            print(e)
        
        print("\n")
        print("1. Insert a Member.")
        print("2. Delete a member")
        print("3. Update a member")
        print("4. Exit.")
        a1 = int(input("enter your choice: "))
        print("\n")
        
        if a1 == 1:
            n = input("enter name: ")
            cn = int(input("enter constituency no: "))
            cname = input("enter constituency name: ")
            m.append(Member(n, cname, cn, "MLA Member"))
        
        elif a1 == 2:
            f = False
            no = int(input("enter constituency number of member to delete: "))
            for e in m[:]:  # Iterate over a copy of the list
                if e.get_const_no() == no:
                    m.remove(e)
                    f = True
            if not f:
                print("member not found")
            else:
                print("member removed.")
        
        elif a1 == 3:
            f2 = False
            no2 = int(input("enter no of constituency to update: "))
            for i, e in enumerate(m):
                if e.get_const_no() == no2:
                    n = input("enter correct name: ")
                    cn = int(input("enter correct constituency no: "))
                    cname = input("enter correct constituency name: ")
                    m[i] = Member(n, cname, cn, "MLA Member")
                    f2 = True
            if not f2:
                print("member not found")
            else:
                print("updated successfully.")
        
        elif a1 == 4:
            print("-----Exiting-------")
            break
        
        else:
            print("please enter valid choice.")


def government():
 

    choice2 = 0

    while choice2 != 4:
        print("\nThe Government")
        print("1. Governor")
        print("2. Chief Minister")
        print("3. Council Of Ministers")
        print("4. Exit")
        choice2 = int(input("Enter your choice: "))
        print("\n")

        if choice2 == 1:
            print("----- The Governor-----")
            print("Shri. P. S. Sreedharan Pillai")

        elif choice2 == 2:
            print("\n----- The Chief Minister-----")
            for e in m:
                if e.get_position() == "Chief Minister":
                    print(e)

        elif choice2 == 3:
            print("----- The Cabinet Ministers-----")
            for e in m:
                if e.get_position() == "Cabinet Minister":
                    print(e)

        elif choice2 == 4:
            print("-----Exiting-------")

        else:
            print("please enter valid choice")


def legislature():
    #import sys

    choice = 0
    i = iter(m)

    while True:
        print("GOA LEGISLATURE")
        print("1. The Speaker")
        print("2. Deputy Speaker")
        print("3. Opposition Leader")
        print("4. Exit")
        choice = int(input("Enter your choice: "))
        print("\n")

        if choice == 1:
            print("----- The Speaker-----")
            i = iter(m)
            for e in i:
                if e.get_position() == "Speaker":
                    print(e)

        elif choice == 2:
            print("----- The Deputy Speaker-----")
            i = iter(m)
            for e in i:
                if e.get_position() == "Deputy Speaker":
                    print(e)

        elif choice == 3:
            print("----- The Leader of Opposition-----")
            i = iter(m)
            for e in i:
                if e.get_position() == "Opposition Leader":
                    print(e)

        elif choice == 4:
            print("-----Exiting-------")
            break

        else:
            print("please enter valid choice")
            print("---------------------------\n")



def main():
    # m.append(Member("nishi", "Mandrem", 1, "MLA Member"))
    m.append(Member("Shri. Jit Arolkar", "Mandrem", 1, "MLA Member"))
    m.append(Member("Shri. Pravin Arlekar", "Pernem", 2, "MLA Member"))
    m.append(Member("Shri. Chandrakant Shetye", "bicholim", 3, "MLA Member"))
    m.append(Member("Shri. Nilkanth Halarnkar", "Tivim", 4, "Cabinet Minister"))
    m.append(Member("Shri. Joshua De Souza", "Mapusa", 5, "Deputy Speaker"))
    m.append(Member("Shri. Rohan Khaunte", "Porvorim", 9, "Cabinet Minister"))
    m.append(Member("Shri. Atanasio Monserrate", "Pnaji", 11, "Cabinet Minister"))
    m.append(Member("Shri. Pramod Sawant", "Sanquelim", 17, "Chief Minister"))
    m.append(Member("Shri. Yuri Alemao", "Cuncolim", 34, "Opposition Leader"))
    m.append(Member("Shri. Ramesh Tawadkar", "Cancona", 40, "Speaker"))
    m.append(Member("Shri. Nilkanth Halarnkar", "Tivim", 4, "Cabinet Minister"))

    while True:
        print("\n \nGOA LEGISLATIVE ASSEMBLY")
        print("1. The Legislature")
        print("2. The Government")
        print("3. MLA's")
        print("4. Exit")
        ch = int(input("Enter your choice: "))
        print("\n")
        if ch == 1:
            legislature()
        elif ch == 2:
            government()
        elif ch == 3:
            MLA()
        elif ch == 4:
            print("-----Exiting-------")
            break
        else:
            print("please enter valid choice.")

if __name__ == "__main__":
    main()