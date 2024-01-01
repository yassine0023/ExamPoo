package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Club {
    private String clubName;
    List<Person> members;

    public Club(String clubName) {
        this.clubName = clubName;
        this.members = new ArrayList();
    }

    public void addMember(Person person) {
        this.members.add(person);
    }

    public boolean isMember(Person P) {
        return this.members.contains(P);
    }

    public void displayMembers() {
        System.out.println("Club " + this.clubName + " members are: ");
        Iterator var2 = this.members.iterator();

        while(var2.hasNext()) {
            Person P = (Person)var2.next();
            System.out.println(P.getName());
        }

    }

    public String getClubName() {
        return this.clubName;
    }
}
