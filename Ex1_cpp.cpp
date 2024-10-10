// Author: Nishita Naik
// Roll no: 28
// Title: Goa Legislative Assembly
// Start date: 15/07/2024
// Modified Date: 22/07/2024
// Description: The program gives the information about the members of Goa Legistative assemly.
// Class Member contains all the attribute of a member in a asssembly.
// It has a method to display all the information.
// we can also perform crud operation like addinfg updationg and deleting a member.




#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Member {
private:
    string name;
    string constName;
    int constNo;
    string position;

public:
    Member(string name, string constName, int constNo, string position) {
        this->name = name;
        this->constName = constName;
        this->constNo = constNo;
        this->position = position;
    }

    string getName() const {
        return name;
    }

    string getConstName() const {
        return constName;
    }

    int getConstNo() const {
        return constNo;
    }

    string getPosition() const {
        return position;
    }

    friend ostream& operator<<(ostream& os, const Member& member) {
        os << member.name << " \nConstituency No/Name: " << member.constNo << "/" << member.constName << "\n";
        return os;
    }
};

class Ex1_cpp {
private:
    static vector<Member> members;

public:
    static void main() {
        members.push_back(Member("Shri. Jit Arolkar", "Mandrem", 1, "MLA Member"));
        members.push_back(Member("Shri. Pravin Arlekar", "Pernem", 2, "MLA Member"));
        members.push_back(Member("Shri. Chandrakant Shetye", "Bicholim", 3, "MLA Member"));
        members.push_back(Member("Shri. Nilkanth Halarnkar", "Tivim", 4, "Cabinet Minister"));
        members.push_back(Member("Shri. Joshua De Souza", "Mapusa", 5, "Deputy Speaker"));
        members.push_back(Member("Shri. Rohan Khaunte", "Porvorim", 9, "Cabinet Minister"));
        members.push_back(Member("Shri. Atanasio Monserrate", "Panaji", 11, "Cabinet Minister"));
        members.push_back(Member("Shri. Pramod Sawant", "Sanquelim", 17, "Chief Minister"));
        members.push_back(Member("Shri. Yuri Alemao", "Cuncolim", 34, "Opposition Leader"));
        members.push_back(Member("Shri. Ramesh Tawadkar", "Cancona", 40, "Speaker"));
        members.push_back(Member("Shri. Nilkanth Halarnkar", "Tivim", 4, "Cabinet Minister"));

        int ch;
        do {
            cout << "\n\nGOA LEGISLATIVE ASSEMBLY\n";
            cout << "1. The Legislature\n";
            cout << "2. The Government\n";
            cout << "3. MLA's\n";
            cout << "4. Exit\n";
            cout << "Enter your choice: ";
            cin >> ch;
            cout << "\n";

            switch (ch) {
                case 1:
                    legislature();
                    break;
                case 2:
                    government();
                    break;
                case 3:
                    mla();
                    break;
                case 4:
                    cout << "-----Exiting-------\n";
                    break;
                default:
                    cout << "Please enter a valid choice.\n";
                    break;
            }
        } while (ch != 4);
    }

    static void mla() {
        int a1;
        do {
            cout << "\n\n-----------MLA Members---------\n";
            for (const auto& member : members) {
                cout << member;
            }
            cout << "\n1. Insert a Member.\n";
            cout << "2. Delete a Member\n";
            cout << "3. Update a Member\n";
            cout << "4. Exit.\n";
            cout << "Enter your choice: ";
            cin >> a1;
            cout << "\n";

            if (a1 == 1) {
                string name, constName;
                int constNo;
                cout << "Enter name: ";
                cin.ignore();
                getline(cin, name);
                cout << "Enter constituency no: ";
                cin >> constNo;
                cout << "Enter constituency name: ";
                cin.ignore();
                getline(cin, constName);
                members.push_back(Member(name, constName, constNo, "MLA Member"));
            } else if (a1 == 2) {
                int constNo;
                cout << "Enter constituency number of member to delete: ";
                cin >> constNo;
                bool found = false;
                for (auto it = members.begin(); it != members.end(); ++it) {
                    if (it->getConstNo() == constNo) {
                        members.erase(it);
                        found = true;
                        cout << "Member removed.\n";
                        break;
                    }
                }
                if (!found) {
                    cout << "Member not found.\n";
                }
            } else if (a1 == 3) {
                int constNo;
                cout << "Enter no of constituency to update: ";
                cin >> constNo;
                bool found = false;
                for (auto& member : members) {
                    if (member.getConstNo() == constNo) {
                        string name, constName;
                        int newConstNo;
                        cout << "Enter correct name: ";
                        cin.ignore();
                        getline(cin, name);
                        cout << "Enter correct constituency no: ";
                        cin >> newConstNo;
                        cout << "Enter correct constituency name: ";
                        cin.ignore();
                        getline(cin, constName);
                        member = Member(name, constName, newConstNo, "MLA Member");
                        found = true;
                        cout << "Updated successfully.\n";
                        break;
                    }
                }
                if (!found) {
                    cout << "Member not found.\n";
                }
            } else if (a1 != 4) {
                cout << "Please enter a valid choice.\n";
            }
        } while (a1 != 4);
    }

    static void government() {
        int choice2;
        do {
            cout << "\nThe Government\n";
            cout << "1. Governor\n";
            cout << "2. Chief Minister\n";
            cout << "3. Council Of Ministers\n";
            cout << "4. Exit\n";
            cout << "Enter your choice: ";
            cin >> choice2;
            cout << "\n";

            if (choice2 == 1) {
                cout << "\n----- The Governor-----\n";
                cout << "Shri. P. S. Sreedharan Pillai\n";
            } else if (choice2 == 2) {
                cout << "\n----- The Chief Minister-----\n";
                for (const auto& member : members) {
                    if (member.getPosition() == "Chief Minister") {
                        cout << member;
                    }
                }
            } else if (choice2 == 3) {
                cout << "\n----- The Cabinet Ministers-----\n";
                for (const auto& member : members) {
                    if (member.getPosition() == "Cabinet Minister") {
                        cout << member;
                    }
                }
            } else if (choice2 != 4) {
                cout << "Please enter a valid choice.\n";
            }
        } while (choice2 != 4);
    }

    static void legislature() {
        int choice;
        do {
            cout << "\n\nGOA LEGISLATURE\n";
            cout << "1. The Speaker\n";
            cout << "2. Deputy Speaker\n";
            cout << "3. Opposition Leader\n";
            cout << "4. Exit\n";
            cout << "Enter your choice: ";
            cin >> choice;
            cout << "\n";

            if (choice == 1) {
                cout << "\n----- The Speaker-----\n";
                for (const auto& member : members) {
                    if (member.getPosition() == "Speaker") {
                        cout << member;
                    }
                }
            } else if (choice == 2) {
                cout << "\n----- The Deputy Speaker-----\n";
                for (const auto& member : members) {
                    if (member.getPosition() == "Deputy Speaker") {
                        cout << member;
                    }
                }
            } else if (choice == 3) {
                cout << "\n----- The Leader of Opposition-----\n";
                for (const auto& member : members) {
                    if (member.getPosition() == "Opposition Leader") {
                        cout << member;
                    }
                }
            } else if (choice != 4) {
                cout << "Please enter a valid choice.\n";
            }
        } while (choice != 4);
    }
};

vector<Member> Ex1_cpp::members;

int main() {
    Ex1_cpp::main();
    return 0;
}