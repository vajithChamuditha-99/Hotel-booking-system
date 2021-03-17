public class Room {
    private static Details[] roomDetails = new Details[20];

    public static void addToRoom(Details details){
        roomDetails[details.getRoomNumber()-1]=details;
    }   // add passenger according to room number

    public static Details[] getRoomDetails() {
        return roomDetails;
    }   // return the whole rooms array

    public static void remove(int index) {
        roomDetails[index]=null;
    }   // delete method

    public static boolean isEmpty(Details det) {
        for (Details details : roomDetails){
            details=det;
            if (details != null) return false;
        }
        return true;    // only if empty
    }

    public static boolean isFull() {
        for (Details details : roomDetails){
            if (details == null) return false;
        }
        return true;    // only if full
    }
}
