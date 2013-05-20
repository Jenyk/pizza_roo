package cz.bcp.roo.pizza.web;

import cz.bcp.roo.pizza.domain.Base;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bases")
@Controller
@RooWebScaffold(path = "bases", formBackingObject = Base.class)
public class BaseController {
}
