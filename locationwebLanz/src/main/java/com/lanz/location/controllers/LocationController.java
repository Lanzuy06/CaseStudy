package com.lanz.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lanz.location.entities.Location;
import com.lanz.location.repos.LocationRepository;
import com.lanz.location.service.LocationService;
import com.lanz.location.util.EmailUtil;
import com.lanz.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	@Autowired
	LocationRepository repository;
	@Autowired
	EmailUtil emailUtil;
	@Autowired
	ReportUtil reportUtil;
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation" ;
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("msg", msg);

		try {
			emailUtil.sendEmail("elucard9@gmail.com", "pls gumana ka", "gumana ka");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return "createLocation";

	}
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations =	service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	@RequestMapping("deleteLocation")
	public String deleteLocation(@RequestParam("id")int id, ModelMap modelMap) {
		//Location location = service.getLocationById(id);
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";	
	}
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location")Location location, ModelMap modelMap){
		service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/generateReport")
	public String generateReport() {
		
		try {
			String path = sc.getRealPath("/");
			List<Object[]> data = repository.findTypeAndTypeCount();
			
			reportUtil.generatePieChart(path, data);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return "report";
	}

}

