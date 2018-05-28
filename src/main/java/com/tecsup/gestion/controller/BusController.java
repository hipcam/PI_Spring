package com.tecsup.gestion.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.model.Bus;
import com.tecsup.gestion.services.BusService;

@Controller
public class BusController {

private static final Logger logger = LoggerFactory.getLogger(BusController.class);
	
	@Autowired
	private BusService busService;
	
	
	@GetMapping("/admin/menu")
	public String list(@ModelAttribute("SpringWeb") Bus bus, ModelMap model) {

		try {
			model.addAttribute("buses", busService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/menu";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{idbus}")
	public ModelAndView home(@PathVariable int idbus, ModelMap model) {

		ModelAndView modelAndView = null;
		Bus bus = new Bus();
		try {
			bus = busService.find(idbus);
			logger.info(bus.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView = new ModelAndView("home", "command", bus);
		return modelAndView;
	}
	
	@GetMapping("/admin/buses/{action}/{id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Bus bus = busService.find(id);
			logger.info(bus.toString());
			modelAndView = new ModelAndView("admin/buses/" + action, "buses", bus);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/buses/" + action, "buses", new Bus());
		}

		return modelAndView;
	}
	
	
	
	@PostMapping("/admin/buses/editsave")
	public ModelAndView editsave(@ModelAttribute("buses") @Valid Bus bus, BindingResult result,
			ModelMap model) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("admin/buses/editform","buses", bus);
		} else {
			try {
				busService.update(bus.getIdbus(), bus.getPlaca());/*NO TOMA EL ID*//*******************************************************************/ 
				modelAndView = new ModelAndView("redirect:/admin/menu");
			} catch (Exception e) {
				// model.addAttribute("message", e.getMessage());
				// modelAndView = new ModelAndView("redirect:/admin/emp/list");
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/buses/editform","buses", bus);
			}
		}
		return modelAndView;
	}
	
//////////////////////////////////////////////////////////////////////////////////////
// DELETE //
//////////////////////////////////////////////////////////////////////////////////////

		@PostMapping("/admin/buses/delete")
			public ModelAndView delete(@ModelAttribute("buses") @Valid Bus bus, BindingResult result, ModelMap model) {
				ModelAndView modelAndView = null;
					if (result.hasErrors()) {
						modelAndView = new ModelAndView("admin/buses/deleteform/" + bus.getIdbus(), "buses", bus);
					} else {
						try {
							busService.delete(bus.getPlaca());
							modelAndView = new ModelAndView("redirect:/admin/menu");
						} catch (Exception e) {
// model.addAttribute("message", e.getMessage());
// modelAndView = new ModelAndView("redirect:/admin/emp/list");
							model.addAttribute("message", e.getMessage());
							modelAndView = new ModelAndView("admin/buses/deleteform", "buses", bus);
						}
					}
					return modelAndView;
		}

//////////////////////////////////////////////////////////////////////////////////////
// CREATION //
//////////////////////////////////////////////////////////////////////////////////////

		@GetMapping("/admin/buses/createform")
		public ModelAndView createform() {
			Bus bus = new Bus();
			ModelAndView modelAndView = new ModelAndView("admin/buses/createform", "buses", bus);
			return modelAndView;
		}
	
		@PostMapping("/admin/buses/create")
		public ModelAndView create(@ModelAttribute("buses") @Valid Bus bus, BindingResult result, ModelMap model) {

// String msg = context.getMessage("employee.salary.min", null, Locale.US);
// logger.info("message = " + msg);

			ModelAndView modelAndView = null;
			if (result.hasErrors()) {
				logger.info("result.getAllErrors();= " + result.getAllErrors());
				modelAndView = new ModelAndView("admin/buses/createform", "buses", bus);
			} else {
				try {
					busService.create(bus.getPlaca());
		
					modelAndView = new ModelAndView("redirect:/admin/menu");
				} catch (DAOException e) {
					logger.error(e.getMessage());
					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("admin/buses/createform", "buses", bus);
				}
			}
			//
			return modelAndView;
		}
	}
