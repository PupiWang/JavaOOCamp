import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {

    private ParkingLot parkingLot;


    @Before
    public void set_up() {
        parkingLot = new ParkingLot(1);
    }

    @Test
    public void park_car_successfully() {
        ParkingTicket parkingTicket = parkingLot.park();
        assertNotNull(parkingTicket);
    }

    @Test
    public void fail_to_park_car_when_parking_lot_is_full() {
        parkingLot.park();
        ParkingTicket parkingTicket = parkingLot.park();
        assertNull(parkingTicket);
    }

    @Test
    public void get_car_successfully() throws InvalidTicketException {
        ParkingTicket parkingTicket = parkingLot.park();
        assertNotNull(parkingLot.getCar(parkingTicket));
    }

    @Test(expected = InvalidTicketException.class)
    public void fail_to_get_car_when_parking_lot_is_full() throws InvalidTicketException {
        parkingLot.getCar(new ParkingTicket());
    }

    @Test
    public void fail_to_get_car_when_parking_lot_is_full1() throws InvalidTicketException {
        ParkingTicket parkingTicket = parkingLot.park();
        parkingLot.getCar(parkingTicket);
        assertNotNull(parkingLot.park());
    }



}