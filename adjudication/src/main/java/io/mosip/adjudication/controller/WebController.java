package io.mosip.adjudication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Controller
public class WebController {

	@RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAny() {
        return ResponseEntity.ok("Hello Adjudicator");
    }

	@RolesAllowed("adjudicator")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello Adjudicator. authenticated.");
    }

}
