import java.util.ArrayList;

public class ParkingBoy {

    private ArrayList<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park() {
        for (ParkingLot parkingLot : parkingLots) {
            ParkingTicket parkingTicket = parkingLot.park();
            if (parkingTicket != null) {
                return parkingTicket;
            }
        }
        return null;
    }

    public Car getCar(ParkingTicket parkingTicket) throws InvalidTicketException {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.getCar(parkingTicket);
            } catch (InvalidTicketException invalidTicket) {
                invalidTicket.printStackTrace();
            }
        }
        throw new InvalidTicketException();
    }
}
