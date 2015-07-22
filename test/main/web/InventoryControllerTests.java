package main.web;

import junit.framework.TestCase;
import org.springframework.web.servlet.ModelAndView;
import service.SimpleProductManager;
import web.InventoryController;

import java.util.Map;

/**
 * Created by 964456 on 29/06/2015.
 */


public class InventoryControllerTests extends TestCase {

    public void testHandleRequestView() throws Exception {
        InventoryController controller = new InventoryController();
        controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView =  controller.handleRequest(null, null);
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue =  (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}
