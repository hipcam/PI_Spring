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
import com.tecsup.gestion.model.Route;
import com.tecsup.gestion.services.RouteService;

/**
 * Handles requests for the application home page.
 */


@Controller
public class RouteController {

	private static final Logger logger = LoggerFactory.getLogger(RouteController.class);
	
	@Autowired
	private 	RouteService routeService;
	
	
	
	
	@GetMapping("/admin/routes/list")
	public String list(@ModelAttribute("SpringWeb") Route route, ModelMap model) {

		try {
			model.addAttribute("routes", routeService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/routes/list";
	}
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{idparadero}")
	public ModelAndView home(@PathVariable int idparadero, ModelMap model) {

		ModelAndView modelAndView = null;
		Route rou = new Route();
		try {
			rou = routeService.findRoute(idparadero);
			logger.info(rou.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", rou);

		return modelAndView;
	}
	
	@GetMapping("/admin/routes/{action}/{id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Route routes = routeService.findRoute(id);
			logger.info(routes.toString());
			modelAndView = new ModelAndView("admin/routes/" + action, "routes", routes);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/routes/" + action, "routes", new Route());
		}

		return modelAndView;
	}
	
	
	
	@PostMapping("/admin/routes/editsave")
	public ModelAndView editsave(@ModelAttribute("routes") @Valid Route routes, BindingResult result,
			ModelMap model) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("admin/routes/editform","routes", routes);
		} else {
			try {
				routeService.update(routes.getNombre(), routes.getUbicacion(), routes.getHorapartida());
				modelAndView = new ModelAndView("redirect:/admin/routes/list");
			} catch (Exception e) {
				// model.addAttribute("message", e.getMessage());
				// modelAndView = new ModelAndView("redirect:/admin/emp/list");
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/routes/editform","routes", routes);
			}
		}
		return modelAndView;
	}
	
//////////////////////////////////////////////////////////////////////////////////////
// DELETE //
//////////////////////////////////////////////////////////////////////////////////////

		@PostMapping("/admin/routes/delete")
			public ModelAndView delete(@ModelAttribute("routes") @Valid Route routes, BindingResult result, ModelMap model) {
				ModelAndView modelAndView = null;
					if (result.hasErrors()) {
						modelAndView = new ModelAndView("admin/routes/deleteform/" + routes.getIdparadero(), "routes", routes);
					} else {
						try {
							routeService.delete(routes.getNombre());
							modelAndView = new ModelAndView("redirect:/admin/routes/list");
						} catch (Exception e) {
// model.addAttribute("message", e.getMessage());
// modelAndView = new ModelAndView("redirect:/admin/emp/list");
							model.addAttribute("message", e.getMessage());
							modelAndView = new ModelAndView("admin/routes/deleteform", "routes", routes);
						}
					}
					return modelAndView;
		}

//////////////////////////////////////////////////////////////////////////////////////
// CREATION //
//////////////////////////////////////////////////////////////////////////////////////

		@GetMapping("/admin/routes/createform")
		public ModelAndView createform() {
			Route routes = new Route();
			ModelAndView modelAndView = new ModelAndView("admin/routes/createform", "routes", routes);
			return modelAndView;
		}
	
		@PostMapping("/admin/routes/create")
		public ModelAndView create(@ModelAttribute("routes") @Valid Route routes, BindingResult result, ModelMap model) {

// String msg = context.getMessage("employee.salary.min", null, Locale.US);
// logger.info("message = " + msg);

			ModelAndView modelAndView = null;
			if (result.hasErrors()) {
				logger.info("result.getAllErrors();= " + result.getAllErrors());
				modelAndView = new ModelAndView("admin/routes/createform", "routes", routes);
			} else {
				try {
					routeService.create(routes.getNombre(), routes.getUbicacion(), routes.getHorapartida());
		
					modelAndView = new ModelAndView("redirect:/admin/routes/list");
				} catch (DAOException e) {
					logger.error(e.getMessage());
					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("admin/routes/createform", "routes", routes);
				}
			}
			//
			return modelAndView;
		}
	}

