package io.mosip.adjudication.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.mosip.adjudication.ProductService;
import java.security.Principal;
import java.util.Map;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ProductController {

   @Autowired ProductService productService;
   private final HttpServletRequest request;
   
   @Autowired
	public ProductController(HttpServletRequest request) {
		this.request = request;
   }
   
   

   @GetMapping(path = "/joblist")
   public String getProducts(Model model){
	   
//	   KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
//	            .getAuthentication();
//
//	        final Principal principal = (Principal) authentication.getPrincipal();

	   System.out.println("hello here");
      model.addAttribute("products", productService.getProducts());
      return "external.html";
   }

   @GetMapping(path = "/logout")
   public String logout() throws ServletException {
      request.logout();
      return "/";
   }
}