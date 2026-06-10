package presentation;

import services.IBusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        IBusinessService metier = context.getBean(IBusinessService.class);
        System.out.println(metier.calcul());
    }
}
