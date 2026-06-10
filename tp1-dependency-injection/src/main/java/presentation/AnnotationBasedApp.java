package presentation;

import services.IBusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBasedApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("repositories","services","extensions");
        IBusinessService metier = context.getBean(IBusinessService.class);
        System.out.println(metier.calcul());
    }
}
