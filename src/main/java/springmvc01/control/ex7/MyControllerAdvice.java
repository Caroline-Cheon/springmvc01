package springmvc01.control.ex7;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class MyControllerAdvice {
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {   // 일관성을 주기위해서 메서드이름을 바인더라고 지정한 것뿐
    System.out.println("MyBindingInitializer.initBinder()...");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }
}
