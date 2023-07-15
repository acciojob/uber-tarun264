package com.driver.services.impl;

import com.driver.model.*;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Customer customer=customerRepository2.findById(customerId).get();
		List<TripBooking>tripBookingList=customer.getTripBookingList();

		/* since customer table is not joined with the driver or cab table
		 * directly, hence cascading will not work for the driver here, therefore, we are making the changes
		 * by manually, and since driver is parent and cab is child making changes in parent (driver) will
		 * automatically make changes in child (cab)*/

		for(TripBooking tripBooking:tripBookingList){
			Driver driver = tripBooking.getDriver();
			Cab cab= tripBooking.getDriver().getCab();
			cab.setAvailable(true);
			driverRepository2.save(driver);
			tripBooking.setStatus(TripStatus.CANCELED);
			}

		customerRepository2.delete(customer);

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		Cab cab= new Cab();
		if(!cab.isAvailable()){
			throw new Exception("No cab available!");
		}
		Driver driver= new Driver();
		return new TripBooking();


	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly



	}

	@Override
	public void completeTrip(Integer tripId) {
		//Complete the trip having given trip Id and update TripBooking attributes accordingly

	}
}
