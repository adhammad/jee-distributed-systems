package presentation;

import repositories.IDaoRepository;
import repositories.IDaoRepositoryImpl;
import services.IBusinessServiceImpl;

public class StaticInjectionApp {
    public static void main(String[] args) {

        IDaoRepository dao = new IDaoRepositoryImpl();
        IBusinessServiceImpl metier = new IBusinessServiceImpl(dao);
        metier.setDao(dao);
        System.out.println("Res = " + metier.calcul());

    }
}
