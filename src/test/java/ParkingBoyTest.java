import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class ParkingBoyTest {

    private ParkingBoy parkingBoy;
    ParkingLot parkingLotA = new ParkingLot(1);
    ParkingLot parkingLotB = new ParkingLot(1);

    @Before
    public void set_up() {
        parkingLotA = new ParkingLot(1);
        parkingLotB = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        parkingBoy = new ParkingBoy(parkingLots);
    }

    @Test
    public void should_park_car_to_the_parking_lot_A() {
        assertEquals(0, parkingLotA.getValidParkingTickets().size());
        assertNotNull(parkingBoy.park());
        assertEquals(1, parkingLotA.getValidParkingTickets().size());
    }

    @Test
    public void should_park_car_to_the_parking_lot_B_when_parking_lot_A_is_full() {
        parkingBoy.park();
        assertNotNull(parkingBoy.park());
        assertEquals(1, parkingLotB.getValidParkingTickets().size());
    }

    @Test
    public void should_return_null_when_both_parking_lot_A_and_B_are_full() {
        parkingBoy.park();
        parkingBoy.park();
        assertNull(parkingBoy.park());
    }

    @Test
    public void should_get_car_successfully() throws InvalidTicketException {
        ParkingTicket parkingTicket = parkingBoy.park();
        assertNotNull(parkingBoy.getCar(parkingTicket));
    }

    @Test(expected = InvalidTicketException.class)
    public void fail_to_get_car() throws InvalidTicketException {
        parkingBoy.getCar(new ParkingTicket());
    }

    @Test
    public void should_get_car_successfully_from_parking_lot_B() throws InvalidTicketException {
        parkingBoy.park();
        ParkingTicket parkingTicket = parkingBoy.park();
        assertNotNull(parkingBoy.getCar(parkingTicket));
    }

}