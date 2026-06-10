package presentation;

import repositories.IDaoRepository;
import services.IBusinessService;

import java.io.File;
import java.util.Scanner;

public class DynamicInjectionApp {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));

            String IdaoClassname = scanner.nextLine();
            Class cDao = Class.forName(IdaoClassname);
            IDaoRepository Dao = (IDaoRepository) cDao.getConstructor().newInstance();

            String ImetieClassname = scanner.nextLine();
            Class cMetier = Class.forName(ImetieClassname);
            IBusinessService Metier = (IBusinessService) cMetier.getConstructor(IDaoRepository.class).newInstance(Dao);

            System.out.println(Metier.calcul());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
