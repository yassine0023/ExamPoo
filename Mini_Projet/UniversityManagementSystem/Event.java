package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Event {
    private String eventName;
    private Date eventDate;
    List<Person> participants;
    private Club organizer;
    private double participationFee;

    public String getEventName() {
        return this.eventName;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public Club getOrganizer() {
        return this.organizer;
    }

    public double getParticipationFee() {
        return this.participationFee;
    }

    public Event(String eventName, Date eventDate, double fees, Club organizer) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.participants = new ArrayList();
        this.participationFee = fees;
        this.organizer = organizer;
    }

    public void addParticipant(Person person) {
        System.out.println(person.getName() + " wants to participate in: " + this.eventName);
        this.participants.add(person);
        this.feesManager(person);
    }

    public void feesManager(Person P) {
        if (this.organizer.isMember(P)) {
            System.out.println("Since you're a member you only have to pay " + this.participationFee * 0.8 + " Dinars");
        } else {
            System.out.println("Participation fees are " + this.participationFee);
        }

    }

    public void displayParticipants() {
        System.out.println("Event " + this.eventName + " by club " + this.organizer.getClubName() + " Participants are: ");
        Iterator var2 = this.participants.iterator();

        while(var2.hasNext()) {
            Person P = (Person)var2.next();
            System.out.println(P.getName());
        }

    }
}

