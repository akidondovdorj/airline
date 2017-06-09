package edu.mum.cs545.ws;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Named
@Path("flight")
public class FlightRest {
	
	@Inject
	private FlightService flightService;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> airlines(){
		return flightService.findAll();
	}
	
	@POST
	@Path("/create")
	public void create( @QueryParam("flightnr") String flightnr, 
			@QueryParam("departureDate") String departureDate,
			@QueryParam("departureTime") String departureTime,
			@QueryParam("arrivalDate") String arrivalDate,
			@QueryParam("arrivalTime") String arrivalTime) {
		Flight flight = new Flight(flightnr, departureDate, departureTime, arrivalDate, arrivalTime);
		flightService.create(flight);
	}

	public void delete(Flight flight) {
		flightService.delete(flight);
	}

	public Flight update(Flight flight) {
		return flightService.update(flight);
	}
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Flight find(@QueryParam("flightId") long flightId) {
		Flight flight = new Flight();
		flight.setId(flightId);
		return flightService.find(flight);
	}
	@GET
	@Path("/findByNumber")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByNumber(@QueryParam("flightnr") String flightnr) {
		return flightService.findByNumber(flightnr);
	}
	@GET
	@Path("/findByAirline")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByAirline(@QueryParam("airlineId") long airlineId) {
		Airline airline = new Airline();
		airline.setId(airlineId);
		return flightService.findByAirline(airline);
	}
	@GET
	@Path("/findByOrigin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByOrigin(@QueryParam("airportId") long airportId) {
		Airport airport = new Airport();
		airport.setId(airportId);
		return flightService.findByOrigin(airport);
	}
	@GET
	@Path("/findByDestination")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByDestination(@QueryParam("airportId") long airportId) {
		Airport airport = new Airport();
		airport.setId(airportId);
		return flightService.findByDestination(airport);
	}
	@GET
	@Path("/findByArrival")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByArrival(@QueryParam("airplaneId") long airplaneId) {
		Airplane airplane = new Airplane();
		airplane.setId(airplaneId);
		return flightService.findByArrival(airplane);
	}
	@GET
	@Path("/findByArrivalByDate")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByArrival(@QueryParam("datetime") Date datetime) {
		return flightService.findByArrival(datetime);
	}
	@GET
	@Path("/findByArrivalBetween")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByArrivalBetween(
			@QueryParam("datetimeFrom") Date datetimeFrom, 
			@QueryParam("datetimeTo") Date datetimeTo) {
		return flightService.findByArrivalBetween(datetimeFrom, datetimeTo);
	}
	@GET
	@Path("/findByDeparture")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByDeparture(@QueryParam("datetime") Date datetime) {
		return flightService.findByDeparture(datetime);
	}
	@GET
	@Path("/findByDepartureBetween")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findByDepartureBetween(
			@QueryParam("datetimeFrom") Date datetimeFrom, 
			@QueryParam("datetimeTo") Date datetimeTo) {
		return flightService.findByDepartureBetween(datetimeFrom, datetimeTo);
	}
	
}
