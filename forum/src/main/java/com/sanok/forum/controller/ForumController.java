package com.sanok.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanok.forum.model.Admin;
import com.sanok.forum.model.Comments;
import com.sanok.forum.model.Theme;
import com.sanok.forum.service.CommentService;
import com.sanok.forum.service.ThemeService;

@Controller
public class ForumController {
	
	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private CommentService commentService;
		
	
	
	
	
	@RequestMapping("/")
	public String home(Model model) {
	        return "redirect:/forum";
	}

		
	@RequestMapping(value = "/forum", method = RequestMethod.GET)
	public String Forum(Model model) {
		model.addAttribute("themes", themeService.getAllThemes());
		model.addAttribute("newtheme", new Theme());
		return "forum";
	}
	
	
	@RequestMapping(value = "/forumAdmin", method = RequestMethod.GET)
	public String ForumAdmin(Model model) {
		model.addAttribute("themes", themeService.getAllThemes());
		model.addAttribute("newtheme", new Theme());
		return "forumAdmin";
	}
	
	
	
	@RequestMapping(value = "/forumAdmin/{idTheme}", method = RequestMethod.GET)
	public String DeleteCommentTopic(Model model, @PathVariable int idTheme) {
		model.addAttribute("theme", themeService.getThemeId(idTheme));
		
		model.addAttribute("newcomments", new Comments());
		return "deleteCommentsTopic";
	}
	
	
	
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String login(Model model) {
		Admin adminLogin =new Admin();
		model.addAttribute("adminLogin",adminLogin);
			return "login";
		}

		
		@RequestMapping(value="/login", method=RequestMethod.POST)
		public String login( @ModelAttribute("adminLogin") Admin adminLogin, BindingResult result) {
			if (result.hasErrors()) {
				return "redirect:/forum";
			} else {
				boolean found = themeService.findByLogin(adminLogin.getAdminName(), adminLogin.getAdminPassword());
				if (found) {				
					return "redirect:/forumAdmin";
				} else {				
					return "redirect:/forum";
				}
			}
		
		}
		
		
		@RequestMapping(value = "/theme/new", method = RequestMethod.POST)
		public String addTheme(Model model, @ModelAttribute("newtheme") Theme theme) {
			themeService.addTheme(theme);
			
			return "redirect:/forum";
		}
		
		@RequestMapping(value = "/forum/{idTheme}", method = RequestMethod.GET)
		public String Comment(Model model, @PathVariable int idTheme) {
			model.addAttribute("theme", themeService.getThemeId(idTheme));
			
			model.addAttribute("newcomments", new Comments());
			return "newComment";
		}
		
		
		@RequestMapping(value = "/forum/comments/addcomment/{idTheme}", method = RequestMethod.POST)
		public String addComments(Model model, @ModelAttribute("newcomments") Comments comments,
				@PathVariable int idTheme) {
			commentService.addComments(idTheme, comments);;
			model.addAttribute("idTheme", idTheme);
		
			return "redirect:/forum/{idTheme}";
		}
		
		@RequestMapping(value = "/forumAdmin/deletecomments", method = RequestMethod.POST)
		public String deleteComment(Model model, @ModelAttribute("idComments") int idComments,
				@ModelAttribute("idTheme") int idTheme) {
			System.out.println("idComments: " + idComments + ", idTheme: " + idTheme);
			
			
			commentService.deleteComments(idComments);
			return "redirect:/forumAdmin/{idTheme}";
		}
		
		
		@RequestMapping(value = "/forumAdmin/deletetheme", method = RequestMethod.POST)
		public String deleteTheme(Model model, @ModelAttribute("idTheme") int idTheme,
				@ModelAttribute("idComments") int idComments) {
			System.out.println("idComments: " + idComments + ", idTheme: " + idTheme);
			themeService.deleteTheme(idTheme);
			return "redirect:/forumAdmin";
		}
		
		
		
		@RequestMapping(value = "/themeAdmin/new", method = RequestMethod.POST)
		public String addThemeAdmin(Model model, @ModelAttribute("newtheme") Theme theme) {
			themeService.addTheme(theme);
			
			return "redirect:/forumAdmin";
		}
		
		
		@RequestMapping(value = "/forumAdmin/deleteCommentsTopic/addcomment/{idTheme}", method = RequestMethod.POST)
		public String addCommentsAdmin(Model model, @ModelAttribute("newcomments") Comments comments,
				@PathVariable int idTheme) {
			commentService.addComments(idTheme, comments);;
			model.addAttribute("idTheme", idTheme);
		
			return "redirect:/forumAdmin/{idTheme}";
		}
		
		
}
