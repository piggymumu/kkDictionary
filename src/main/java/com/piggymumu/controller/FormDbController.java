package com.piggymumu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.piggymumu.form.JobsResultBean;
import com.piggymumu.modelview.WordModelView;
import com.piggymumu.service.ConnectDbService;

@Controller
public class FormDbController {


	@Autowired
	private ConnectDbService service;


	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String test0001Method(Model model) {
		WordModelView wordView = new WordModelView();
		model.addAttribute("message", "Welcome");
		model.addAttribute("wordView", wordView);
		return "showMessage";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String getFormInfo( Model model ,WordModelView resultView ) {

		List<JobsResultBean> lists=service.getTableJobs01(resultView.getWord());
		if(lists == null || lists.size() == 0){
			model.addAttribute("message", "このワードの意味はまだ収録されていません");
		}
		model.addAttribute("lists", lists);
		model.addAttribute("wordView", resultView);

	    return "showMessage";
	}
}
