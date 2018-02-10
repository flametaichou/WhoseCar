package ru.flametaichou.whosecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	  @RequestMapping("/")
	    public String getIndexPage() {
		  return "index";
	    }

		@RequestMapping("/search-car")
		public String getCarSearchPage() {
			return "SearchCar";
		}

		@RequestMapping("/search-room")
		public String getRoomSearchPage() {
			return "SearchRoom";
		}

		@RequestMapping("/admin")
		public String getAdminPage() {
			return "Admin";
		}

		@RequestMapping("/cars-list")
		public String getCarsList() {
			return "CarsList";
		}
}