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

	@Test
	void contextLoads() {}

	@Test
	void saveUser(){

		UserDto userDto = new UserDto(1,"Juan","Quito","juanpis1150@gmail.com","Juanito1150", true, "1027283212", ERoles.Client);

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

		UserDto userDto = new UserDto(1,"Juan","Quito","juanpis1150@gmail.com","Juanito1150", true, "1027283212", ERoles.Client);

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
		UserDto userDto = new UserDto(1,"Maria","Quito","mapis2321@gmail.com","Mapis1150", true, "1027283212", ERoles.Client);
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
	void substractUserById() throws ReservationException {

		UserDto userDto = new UserDto(1,"Juan","Quito","juanpis1150@gmail.com","Juanito1150", true, "1027283212", ERoles.Client);

		Integer userDtoId = userDto.id();
		int result = userDtoId;
		int expected = 1;

		try {
			userService.substractUser(userDtoId);
			assertEquals(expected, result);
		} catch (ReservationException e) {
			e.printStackTrace();
		}
	}

	@Test
	void saveBooking(){

		UserDto userDto = new UserDto(1,"Juan","Quito","juanpis1150@gmail.com","Juanito1150", true, "1027283212", ERoles.Client);
		BookingDto bookingDto = new BookingDto(1,LocalDate.of(2023, 5, 10), LocalTime.of(14, 30),"Cumpleaños", EStateReservation.Active,userDto);

		bookingService.createBooking(bookingDto);
		Booking result = mapperB.toEntity(bookingDto);

		assertNotNull(result);
		assertEquals(bookingDto.id(), result.getId());
		assertEquals(bookingDto.bookingDate(), result.getBookingDate());
		assertEquals(bookingDto.bookingHour(), result.getBookingHour());
		assertEquals(bookingDto.description(), result.getDescription());
		assertEquals(bookingDto.stateReservation(), result.getStateReservation());
		assertEquals(bookingDto.user(), result.getUser());
	}

	@Test
	void findBookingById() throws ReservationException {

		UserDto userDto = new UserDto(1,"Juan","Quito","juanpis1150@gmail.com","Juanito1150", true, "1027283212", ERoles.Client);
		BookingDto bookingDto = new BookingDto(1,LocalDate.of(2023, 5, 10), LocalTime.of(14, 30),"Cumpleaños", EStateReservation.Active,userDto);

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
		UserDto userDto = new UserDto(1,"Maria","Quito","mapis2321@gmail.com","Mapis1150", true, "1027283212", ERoles.Client);
		BookingDto bookingDto = new BookingDto(1,LocalDate.of(2023, 5, 10), LocalTime.of(14, 30),"Cumpleaños", EStateReservation.Active,userDto);
		Integer bookingDtoId = bookingDto.id();

		try {
			bookingService.updateBooking(bookingDtoId,bookingDto);
			Booking result = mapperB.toEntity(bookingDto);

			assertNotNull(result);
			assertEquals(bookingDto.id(), result.getId());
			assertEquals(bookingDto.bookingDate(), result.getBookingDate());
			assertEquals(bookingDto.bookingHour(), result.getBookingHour());
			assertEquals(bookingDto.description(), result.getDescription());
			assertEquals(bookingDto.stateReservation(), result.getStateReservation());
			assertEquals(bookingDto.user(), result.getUser());

		}catch (ReservationException e){
			e.printStackTrace();
		}
	}
	@Test
	void saveTable(){

		UserDto userDto = new UserDto(1,"Juan","Quito","juanpis1150@gmail.com","Juanito1150", true, "1027283212", ERoles.Client);
		BookingDto bookingDto = new BookingDto(1,LocalDate.of(2023, 5, 10), LocalTime.of(14, 30),"Cumpleaños", EStateReservation.Active,userDto);
		TableDto tableDto = new TableDto(1,6, EStateTable.Available,bookingDto);

		tableService.createTable(tableDto);
		Table result = mapperT.toEntity(tableDto);

		assertNotNull(result);
		assertEquals(tableDto.id(), result.getId());
		assertEquals(tableDto.chairsNumber(), result.getChairsNumber());
		assertEquals(tableDto.stateTable(), result.getStateTable());
		assertEquals(tableDto.booking(), result.getBooking());
	}

	@Test
	void findTableById() throws ReservationException {

		UserDto userDto = new UserDto(1,"Juan","Quito","juanpis1150@gmail.com","Juanito1150", true, "1027283212", ERoles.Client);
		BookingDto bookingDto = new BookingDto(1,LocalDate.of(2023, 5, 10), LocalTime.of(14, 30),"Cumpleaños", EStateReservation.Active,userDto);
		TableDto tableDto = new TableDto(1,6, EStateTable.Available,bookingDto);

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
		UserDto userDto = new UserDto(1,"Maria","Quito","mapis2321@gmail.com","Mapis1150", true, "1027283212", ERoles.Client);
		BookingDto bookingDto = new BookingDto(1,LocalDate.of(2023, 5, 10), LocalTime.of(14, 30),"Cumpleaños", EStateReservation.Active,userDto);
		TableDto tableDto = new TableDto(1,6, EStateTable.Available,bookingDto);
		Integer tableDtoId = tableDto.id();

		try {
			tableService.updateTable(tableDtoId,tableDto);
			Table result = mapperT.toEntity(tableDto);

			assertNotNull(result);
			assertEquals(tableDto.id(), result.getId());
			assertEquals(tableDto.chairsNumber(), result.getChairsNumber());
			assertEquals(tableDto.stateTable(), result.getStateTable());
			assertEquals(tableDto.booking(), result.getBooking());

		}catch (ReservationException e){
			e.printStackTrace();
		}
	}

}
