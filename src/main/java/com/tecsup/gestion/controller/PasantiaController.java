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
import com.tecsup.gestion.model.Pasantia;
import com.tecsup.gestion.services.PasantiaService;

@Controller
public class PasantiaController {

private static final Logger logger = LoggerFactory.getLogger(PasantiaController.class);
	
	@Autowired
	private PasantiaService pasantiaService;
	
	
	
	
	@GetMapping("/admin/pasant/list")
	public String list(@ModelAttribute("SpringWeb") Pasantia pasantia, ModelMap model) {

		try {
			model.addAttribute("pasantias", pasantiaService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/pasant/list";
	}
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{idpasantia}")
	public ModelAndView home(@PathVariable int idpasantia, ModelMap model) {

		ModelAndView modelAndView = null;
		Pasantia pas = new Pasantia();
		try {
			pas = pasantiaService.find(idpasantia);
			logger.info(pas.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", pas);

		return modelAndView;
	}
	
	@GetMapping("/admin/pasant/{action}/{id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Pasantia pasant= pasantiaService.find(id);
			logger.info(pasant.toString());
			modelAndView = new ModelAndView("admin/pasant/" + action, "pasant", pasant);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/pasant/" + action, "pasant", new Pasantia());
		}

		return modelAndView;
	}
	
	
	
	@PostMapping("/admin/pasant/editsave")
	public ModelAndView editsave(@ModelAttribute("pasant") @Valid Pasantia pasant, BindingResult result,
			ModelMap model) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("admin/pasant/editform","pasant", pasant);
		} else {
			try {
				pasantiaService.update(pasant.getUbicacion(), pasant.getNombre_empresa(), pasant.getAlumno_idalumno(), pasant.getFecha());
						modelAndView = new ModelAndView("redirect:/admin/pasant/list");
			} catch (Exception e) {
				// model.addAttribute("message", e.getMessage());
				// modelAndView = new ModelAndView("redirect:/admin/emp/list");
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/pasant/editform","pasant", pasant);
			}
		}
		return modelAndView;
	}
	
//////////////////////////////////////////////////////////////////////////////////////
// DELETE //
//////////////////////////////////////////////////////////////////////////////////////

		@PostMapping("/admin/pasant/delete")
			public ModelAndView delete(@ModelAttribute("buses") @Valid Pasantia pasant, BindingResult result, ModelMap model) {
				ModelAndView modelAndView = null;
					if (result.hasErrors()) {
						modelAndView = new ModelAndView("admin/pasant/deleteform/" + pasant.getIdpasantia(), "pasant", pasant);
					} else {
						try {
							pasantiaService.delete(pasant.getAlumno_idalumno());
							modelAndView = new ModelAndView("redirect:/admin/pasant/list");
						} catch (Exception e) {
// model.addAttribute("message", e.getMessage());
// modelAndView = new ModelAndView("redirect:/admin/emp/list");
							model.addAttribute("message", e.getMessage());
							modelAndView = new ModelAndView("admin/pasant/deleteform", "pasant", pasant);
						}
					}
					return modelAndView;
		}

//////////////////////////////////////////////////////////////////////////////////////
// CREATION //
//////////////////////////////////////////////////////////////////////////////////////

		@GetMapping("/admin/pasant/createform")
		public ModelAndView createform() {
			Pasantia pasant = new Pasantia();
			ModelAndView modelAndView = new ModelAndView("admin/pasant/createform", "pasant", pasant);
			return modelAndView;
		}
	
		@PostMapping("/admin/pasant/create")
		public ModelAndView create(@ModelAttribute("pasant") @Valid Pasantia pasant, BindingResult result, ModelMap model) {

// String msg = context.getMessage("employee.salary.min", null, Locale.US);
// logger.info("message = " + msg);

			ModelAndView modelAndView = null;
			if (result.hasErrors()) {
				logger.info("result.getAllErrors();= " + result.getAllErrors());
				modelAndView = new ModelAndView("admin/pasant/createform", "pasant", pasant);
			} else {
				try {
					pasantiaService.create(pasant.getUbicacion(), pasant.getNombre_empresa(), pasant.getAlumno_idalumno(), pasant.getFecha());
		
					modelAndView = new ModelAndView("redirect:/admin/pasant/list");
				} catch (DAOException e) {
					logger.error(e.getMessage());
					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("admin/pasant/createform", "pasant", pasant);
				}
			}
			//
			return modelAndView;
		}
	}


