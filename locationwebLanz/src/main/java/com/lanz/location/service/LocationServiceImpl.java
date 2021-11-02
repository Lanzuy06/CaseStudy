package com.lanz.location.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lanz.location.entities.Location;
import com.lanz.location.repos.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationRepository repository;
	
	public Location saveLocation(Location location) {
		return repository.save(location);
	}

	public Location updateLocation(Location location) {
		return repository.save(location);
	}

	public void deleteLocation(Location location) {
		repository.delete(location);

	}

	public Location getLocationById(int id) {
		return repository.findById(id).get();
	}

	public List<Location> getAllLocations() {
		return repository.findAll();
	}

}
