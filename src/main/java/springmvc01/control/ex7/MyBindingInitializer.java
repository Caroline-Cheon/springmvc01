package springmvc01.control.ex7;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class MyBindingInitializer implements WebBindingInitializer{
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  
  @Override
  public void initBinder(WebDataBinder binder, WebRequest request) {
    System.out.println("MyBindingInitializer.initBinder()...");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }
}
