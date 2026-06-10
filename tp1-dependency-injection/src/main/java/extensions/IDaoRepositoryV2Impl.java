package extensions;

import repositories.IDaoRepository;
import org.springframework.stereotype.Repository;

@Repository("daoV2")
public class IDaoRepositoryV2Impl implements IDaoRepository {
    @Override
    public double getData() {
        System.out.println("get Data V2");
        return 12;
    }
}
