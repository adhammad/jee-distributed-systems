package services;

import repositories.IDaoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service()
public class IBusinessServiceImpl implements IBusinessService {

    private IDaoRepository dao;

    public void setDao(IDaoRepository dao) {
        this.dao = dao;
    }

    public IBusinessServiceImpl(@Qualifier("dao") IDaoRepository dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return dao.getData() * 23;
    }
}
