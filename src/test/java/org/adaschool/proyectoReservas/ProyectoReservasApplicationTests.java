package org.adaschool.proyectoReservas;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.lasting.ERoles;
import org.adaschool.proyectoReservas.application.lasting.EStateReservation;
import org.adaschool.proyectoReservas.application.lasting.EStateTable;
import org.adaschool.proyectoReservas.application.mapper.IBookingMapper;
import org.adaschool.proyectoReservas.application.mapper.ITableMapper;
import org.adaschool.proyectoReservas.application.mapper.IUserMapper;
import org.adaschool.proyectoReservas.application.service.BookingService;
import org.adaschool.proyectoReservas.application.service.TableService;
import org.adaschool.proyectoReservas.application.service.UserService;
import org.adaschool.proyectoReservas.domain.dto.BookingDto;
import org.adaschool.proyectoReservas.domain.dto.TableDto;
import org.adaschool.proyectoReservas.domain.dto.UserDto;
import org.adaschool.proyectoReservas.domain.entity.Booking;
import org.adaschool.proyectoReservas.domain.entity.Table;
import org.adaschool.proyectoReservas.domain.entity.User;
import org.adaschool.proyectoReservas.domain.repository.BookingRepository;
import org.adaschool.proyectoReservas.domain.repository.TableRepository;
import org.adaschool.proyectoReservas.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProyectoReservasApplicationTests {


	private UserService userService;
	private TableService tableService;
	private BookingService bookingService;
	@Autowired
	private IUserMapper mapper;
	@Autowired
	private ITableMapper mapperT;
	@Autowired
	private IBookingMapper mapperB;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TableRepository tableRepository;
	@Autowired
	private BookingRepository bookingRepository;

	@BeforeEach
	void setUp(){
		userService = new UserService(userRepository,mapper);
		tableService = new TableService(tableRepository,mapperT);
		bookingService = new BookingService(bookingRepository,mapperB);
	}

	User user = new User(1,"Juan","Quito","juanpis1150@gmail.com","Juanito1150", true, "1027283212", ERoles.Client);
	Booking booking = new Booking(1,LocalDate.of(2023, 5, 10), LocalTime.of(14, 30),"para un cumpleaños", EStateReservation.Active,user);
	Table table = new Table(1,6,EStateTable.Available,booking);

	@Test
	void contextLoads() {}

	@Test
	void saveUser(){

		UserDto userDto = mapper.toDto(user);
		userService.createUser(userDto);


		User result = mapper.toEntity(userDto);

		assertNotNull(result);
		assertEquals(userDto.id(), result.getId());
		assertEquals(userDto.name(), result.getName());
		assertEquals(userDto.lastName(), result.getLastName());
		assertEquals(userDto.email(), result.getEmail());
		assertEquals(userDto.password(), result.getPassword());
		assertEquals(userDto.enable(), result.isEnable());
		assertEquals(userDto.document(), result.getDocument());
		assertEquals(userDto.roles(), result.getRoles());
	}

	@Test
	void findUserById() throws ReservationException {

		UserDto userDto = mapper.toDto(user);
		int result = userDto.id();
		int expected = 1;

		try {
			userService.findUserById(result);
			assertEquals(expected, result);
		} catch (ReservationException e) {
			e.printStackTrace();
		}
	}

	@Test
	void listAllUsers() throws ReservationException {
		int offset = 1;
		int limit = 50;
		try {
			userService.listAllUsers(offset,limit);

		}catch (ReservationException e){
			e.printStackTrace();
		}
	}

	@Test
	void updateUser() throws ReservationException {

		UserDto userDto = mapper.toDto(user);
		Integer userDtoId = userDto.id();

		try {
			userService.updateUser(userDtoId,userDto);
			User result = mapper.toEntity(userDto);

			assertNotNull(result);
			assertEquals(userDto.id(), result.getId());
			assertEquals(userDto.name(), result.getName());
			assertEquals(userDto.lastName(), result.getLastName());
			assertEquals(userDto.email(), result.getEmail());
			assertEquals(userDto.password(), result.getPassword());
			assertEquals(userDto.enable(), result.isEnable());
			assertEquals(userDto.document(), result.getDocument());
			assertEquals(userDto.roles(), result.getRoles());

		}catch (ReservationException e){
			e.printStackTrace();
		}
	}

	@Test
	void saveBooking(){

		UserDto userDto = mapper.toDto(user);
		BookingDto bookingDto = mapperB.toDto(booking);

		bookingService.createBooking(bookingDto);

		assertNotNull(booking);
		assertEquals(bookingDto.id(), booking.getId());
		assertEquals(bookingDto.bookingDate(), booking.getBookingDate());
		assertEquals(bookingDto.bookingHour(), booking.getBookingHour());
		assertEquals(bookingDto.description(), booking.getDescription());
		assertEquals(bookingDto.stateReservation(), booking.getStateReservation());

		assertEquals(userDto.id(), booking.getUser().getId());
		assertEquals(userDto.name(), booking.getUser().getName());
		assertEquals(userDto.lastName(), booking.getUser().getLastName());
		assertEquals(userDto.email(), booking.getUser().getEmail());
		assertEquals(userDto.password(), booking.getUser().getPassword());
		assertEquals(userDto.enable(), booking.getUser().isEnable());
		assertEquals(userDto.document(), booking.getUser().getDocument());
		assertEquals(userDto.roles(), booking.getUser().getRoles());
	}

	@Test
	void findBookingById() throws ReservationException {

		BookingDto bookingDto = mapperB.toDto(booking);

		int result = bookingDto.id();
		int expected = 1;

		try {
			userService.findUserById(result);
			assertEquals(expected, result);
		} catch (ReservationException e) {
			e.printStackTrace();
		}
	}

	@Test
	void listAllBookings() throws ReservationException {
		int offset = 1;
		int limit = 50;
		try {
			bookingService.listAllBookings(offset,limit);

		}catch (ReservationException e){
			e.printStackTrace();
		}
	}

	@Test
	void updateBooking() throws ReservationException {

		BookingDto bookingDto = mapperB.toDto(booking);
		Integer bookingDtoId = bookingDto.id();

		try {

			bookingService.updateBooking(bookingDtoId, bookingDto);

			assertNotNull(booking);
			assertEquals(bookingDto.id(), booking.getId());
			assertEquals(bookingDto.bookingDate(), booking.getBookingDate());
			assertEquals(bookingDto.bookingHour(), booking.getBookingHour());
			assertEquals(bookingDto.description(), booking.getDescription());
			assertEquals(bookingDto.stateReservation(), booking.getStateReservation());

			UserDto userDto = bookingDto.user();
			assertEquals(userDto.id(), booking.getUser().getId());
			assertEquals(userDto.name(), booking.getUser().getName());
			assertEquals(userDto.lastName(), booking.getUser().getLastName());
			assertEquals(userDto.email(), booking.getUser().getEmail());
			assertEquals(userDto.password(), booking.getUser().getPassword());
			assertEquals(userDto.enable(), booking.getUser().isEnable());
			assertEquals(userDto.document(), booking.getUser().getDocument());
			assertEquals(userDto.roles(), booking.getUser().getRoles());
		} catch (ReservationException e) {
			e.printStackTrace();
		}
	}

	@Test
	void saveTable(){

		BookingDto bookingDto = mapperB.toDto(booking);
		TableDto tableDto = mapperT.toDto(table);

		tableService.createTable(tableDto);

		assertNotNull(table);
		assertEquals(tableDto.id(), table.getId());
		assertEquals(tableDto.chairsNumber(), table.getChairsNumber());
		assertEquals(tableDto.stateTable(), table.getStateTable());

		assertEquals(bookingDto.id(), table.getBooking().getId());
		assertEquals(bookingDto.bookingDate(), table.getBooking().getBookingDate());
		assertEquals(bookingDto.bookingHour(), table.getBooking().getBookingHour());
		assertEquals(bookingDto.description(), table.getBooking().getDescription());
		assertEquals(bookingDto.stateReservation(), table.getBooking().getStateReservation());
	}


	@Test
	void findTableById() throws ReservationException {

		TableDto tableDto = mapperT.toDto(table);
		int result = tableDto.id();
		int expected = 1;

		try {
			userService.findUserById(result);
			assertEquals(expected, result);
		} catch (ReservationException e) {
			e.printStackTrace();
		}
	}

	@Test
	void listAllTables() throws ReservationException {
		int offset = 1;
		int limit = 50;
		try {
			tableService.listAllTables(offset,limit);

		}catch (ReservationException e){
			e.printStackTrace();
		}
	}

	@Test
	void updateTable() throws ReservationException {

		TableDto tableDto = mapperT.toDto(table);
		Integer tableDtoId = tableDto.id();

		try {
			tableService.updateTable(tableDtoId, tableDto);

			assertNotNull(table);
			assertEquals(tableDto.id(), table.getId());
			assertEquals(tableDto.chairsNumber(), table.getChairsNumber());
			assertEquals(tableDto.stateTable(), table.getStateTable());

			assertEquals(tableDto.booking().id(), table.getBooking().getId());
			assertEquals(tableDto.booking().bookingDate(), table.getBooking().getBookingDate());
			assertEquals(tableDto.booking().bookingHour(), table.getBooking().getBookingHour());
			assertEquals(tableDto.booking().description(), table.getBooking().getDescription());
			assertEquals(tableDto.booking().stateReservation(), table.getBooking().getStateReservation());

			assertEquals(tableDto.booking().user().id(), table.getBooking().getUser().getId());
			assertEquals(tableDto.booking().user().name(), table.getBooking().getUser().getName());
			assertEquals(tableDto.booking().user().lastName(), table.getBooking().getUser().getLastName());
			assertEquals(tableDto.booking().user().email(), table.getBooking().getUser().getEmail());
			assertEquals(tableDto.booking().user().password(), table.getBooking().getUser().getPassword());
			assertEquals(tableDto.booking().user().enable(), table.getBooking().getUser().isEnable());
			assertEquals(tableDto.booking().user().document(), table.getBooking().getUser().getDocument());
			assertEquals(tableDto.booking().user().roles(), table.getBooking().getUser().getRoles());

		} catch (ReservationException e) {
			e.printStackTrace();
		}
	}

}
