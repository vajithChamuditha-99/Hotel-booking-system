public class Details {
    private String firstName;
    private String lastName;
    private String idNumber;
    private String contactDetails;
    private int roomNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getName() {
        return firstName+" "+lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Details(String firstName, String lastName, String idNumber, String contactDetails, int roomNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.contactDetails = contactDetails;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Name : '" + firstName + " "+ lastName + '\'' +
                ", idNumber : '" + idNumber + '\'' +
                ", contactDetails : '" + contactDetails + '\'' +
                ", Room Number : '" + roomNumber +'\''
                ;
    }
}
